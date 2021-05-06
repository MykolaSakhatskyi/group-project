package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.LoginPage;
import pages.MainPage;

public class LoginPositiveTest extends BaseTest {

    @Test
    public void loginWithCorrectValues () {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBookStoreApplicationButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("books"),"Book page was not opened");

        BooksPage booksPage = new BooksPage(driver);
        booksPage.setLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Login page was not opened");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsernameField("Testic");
        loginPage.setPasswordField("A1234@!z");
        loginPage.setLoginButton();
        //Assert.assertTrue(driver.getCurrentUrl().contains("profile"),"Profile page was not opened");
    }

}
