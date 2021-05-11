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
        return new Object[][]{{"","","emptyFields"},{"",password,"usernameFieldIsEmpty"},{username,"","passwordFieldIsEmpty"}, //новый объект лучше писать с новой строки, чтоб лучше читалось
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
        loginPage.clickLoginButton();
        if (passedValues.equals("emptyFields")) { // лучше использовать свитч кейс. А так же "==" работает со строками другим способом, нужно юзать equals. "==" указывает, что обе ссылки ссылкаются на 1 и тот же объект, а не его содержание. В данном случае все работает, так как компилятор "умный" и создал 1 объект для этой строки и соответственно, тест проходит. Но если создать новую строку String("текст"), то он упадет. Или если значение будет браться с сайта, например.
            Assert.assertNotNull(loginPage.getUserNameFieldEmpty().isEnabled()); // Проверка на null? Тут необходимо проверить тру или фолс, но никак не налл. Если у нас объект будет налл, то тест упадет в любом случае, так как из него пытается вытащить булевое значение
            Assert.assertNotNull(loginPage.getPasswordFieldEmpty().isEnabled());}
        else if (passedValues.equals("usernameFieldIsEmpty"))
            Assert.assertNotNull(loginPage.getUserNameFieldEmpty().isEnabled());
        else if (passedValues.equals("passwordFieldIsEmpty"))
            Assert.assertNotNull(loginPage.getPasswordFieldEmpty().isEnabled());
        else if (passedValues.equals("incorrectPassword")) {
            loginPage.waitingErrorMessage();
            Assert.assertEquals(loginPage.getErrorMassage().getText(), "Invalid username or password!");
        }
        else if (passedValues.equals("incorrectUsername")) {
            loginPage.waitingErrorMessage();
            Assert.assertEquals(loginPage.getErrorMassage().getText(), "Invalid username or password!"); }
    }
}
