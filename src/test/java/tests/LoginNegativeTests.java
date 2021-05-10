package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.LoginPage;
import pages.MainPage;

public class LoginNegativeTests extends BaseTest {

    @DataProvider(name = "valuesToEnter")
    private Object[][] valuesToEnter() {
        String password = "A1234@!z";
        String username = "Testic";
        return new Object[][]{{"","","emptyFields"},{"",password,"usernameFieldIsEmpty"},{username,"","passwordFieldIsEmpty"},
                {username,"wrong_password","incorrectPassword"},{"wrong_username",password,"incorrectUsername"}};
    }

    @Test(dataProvider = "valuesToEnter")
    public void loginWithDifferentUserNames(String username, String password, String passedValues) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBookStoreApplicationButton();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.setLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.setLoginButton();
        if (passedValues == "emptyFields") {
            Assert.assertNotNull(loginPage.getUserNameFieldEmpty().isEnabled());
            Assert.assertNotNull(loginPage.getPasswordFieldEmpty().isEnabled());}
        else if (passedValues == "usernameFieldIsEmpty")
            Assert.assertNotNull(loginPage.getUserNameFieldEmpty().isEnabled());
        else if (passedValues == "passwordFieldIsEmpty")
            Assert.assertNotNull(loginPage.getPasswordFieldEmpty().isEnabled());
        else if (passedValues == "incorrectPassword") {
            loginPage.error();
            Assert.assertEquals(loginPage.getErrorMassage().getText(), "Invalid username or password!");
        }
        else if (passedValues == "incorrectUsername") {
            loginPage.error();
            Assert.assertEquals(loginPage.getErrorMassage().getText(), "Invalid username or password!"); }
    }
}
