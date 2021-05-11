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
        return new Object[][]{{"", "", "emptyFields"}, {"", password, "usernameFieldIsEmpty"}, {username, "", "passwordFieldIsEmpty"}, //новый объект лучше писать с новой строки, чтоб лучше читалось
                {username, "wrong_password", "incorrectPassword"}, {"wrong_username", password, "incorrectUsername"}};
    }

    @Test(dataProvider = "valuesToEnter")
    public void loginWithDifferentUserNames(String username, String password, String passedValues) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBookStoreApplicationButton();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.setLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        loginPage.clickLoginButton();
        switch (passedValues) {
            case "emptyFields":
                Assert.assertTrue(loginPage.getUserNameFieldEmpty().isEnabled());
                Assert.assertTrue(loginPage.getPasswordFieldEmpty().isEnabled());
                break;
            case "usernameFieldIsEmpty":
                Assert.assertTrue(loginPage.getUserNameFieldEmpty().isEnabled());
                break;
            case "passwordFieldIsEmpty":
                Assert.assertTrue(loginPage.getPasswordFieldEmpty().isEnabled());
                break;
            case "incorrectPassword":
                loginPage.waitingErrorMessage();
                Assert.assertEquals(loginPage.getErrorMassage().getText(), "Invalid username or password!");
                break;
            case "incorrectUsername":
                loginPage.waitingErrorMessage();
                Assert.assertEquals(loginPage.getErrorMassage().getText(), "Invalid username or password!");
        }
    }
}
