package tests;

import helpers.BaseTest;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.LoginPage;
import pages.MainPage;

public class LoginPositiveTest extends BaseTest {

    @Test
    public void loginWithCorrectValues () {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBookStoreApplicationButton();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.setLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

}
