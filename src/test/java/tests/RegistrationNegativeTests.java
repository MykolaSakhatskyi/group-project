package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

public class RegistrationNegativeTests extends BaseTest {

    @DataProvider(name = "valuesToRegister")
    private Object[][] valuesToEnter() {
        String password = "A1234@!z";
        String username = "Testic";
        return new Object[][]{{"","","","","BackToLogin"},{"","","","","GetAllErrorsFields"},{"SomeFirstName","SomeLastName",username,password,"UserExists"},
                {"SomeFirstName","SomeLastName",username,password,"verifyCaptcha"},{"SomeFirstName","SomeLastName",username,1111,"passwordError"}};
    }

    @Test(dataProvider = "valuesToRegister")
    public void registrationWithDifferensValues(String firstname, String lastname, String username, String password, String passedValues) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBookStoreApplicationButton();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.setLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getNewUserButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("register"),"Register page was not opened");

        RegisterPage registerPage = new RegisterPage(driver);

        if (passedValues == "BackToLogin") { // лучше использовать свитч кейс. А так же "==" работает со строками другим способом, нужно юзать equals. "==" указывает, что обе ссылки ссылкаются на 1 и тот же объект, а не его содержание. В данном случае все работает, так как компилятор "умный" и создал 1 объект для этой строки и соответственно, тест проходит. Но если создать новую строку String("текст"), то он упадет. Или если значение будет браться с сайта, например.
            registerPage.getBackToLoginButton().click();
            Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Back to Login button doesn't open Login page");
            }
        else if (passedValues == "GetAllErrorsFields") {
            registerPage.getRegisterButton().click();
            Assert.assertNotNull(registerPage.getFirsNameFieldEmpty().isEnabled()); // Проверка на null? Тут необходимо проверить тру или фолс, но никак не налл. Если у нас объект будет налл, то тест упадет в любом случае, так как из него пытается вытащить булевое значение
            Assert.assertNotNull(registerPage.getLastNameFieldEmpty().isEnabled());
            Assert.assertNotNull(registerPage.getUserNameFieldEmpty().isEnabled());
            Assert.assertNotNull(registerPage.getPasswordFieldEmpty().isEnabled());
        }
        else if (passedValues == "UserExists") {
            registerPage.setFirsNameField(firstname);
            registerPage.setLastNameField(lastname);
            registerPage.setUsernameField(username);
            registerPage.setPasswordField(password);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            registerPage.switchToCaptchaFrame();
            registerPage.getCaptchaCheckbox().click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            registerPage.switchToMainWindow();
            registerPage.getRegisterButton().click();
            Assert.assertEquals(registerPage.getError().getText(),"User exists!");
        }
        else if (passedValues == "verifyCaptcha") {
            registerPage.setFirsNameField(firstname);
            registerPage.setLastNameField(lastname);
            registerPage.setUsernameField(username);
            registerPage.setPasswordField(password);
            registerPage.getRegisterButton().click();
            Assert.assertEquals(registerPage.getError().getText(),"Please verify reCaptcha to register!");
        }
        else if (passedValues == "passwordError") {
            registerPage.setFirsNameField(firstname);
            registerPage.setLastNameField(lastname);
            registerPage.setUsernameField(username);
            registerPage.setPasswordField(password);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            registerPage.switchToCaptchaFrame();
            registerPage.getCaptchaCheckbox().click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            registerPage.switchToMainWindow();
            registerPage.getRegisterButton().click();
            Assert.assertEquals(registerPage.getError().getText(),"Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.");
        }
    }
}
