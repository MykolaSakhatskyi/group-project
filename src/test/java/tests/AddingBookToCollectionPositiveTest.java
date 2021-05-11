package tests;

import helpers.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class AddingBookToCollectionPositiveTest extends BaseTest {

    @Test
    public void addingBookToCollectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBookStoreApplicationButton();

        BooksPage booksPage = new BooksPage(driver);
        booksPage.setLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(LoginPage.USERNAME, LoginPage.PASSWORD);

        booksPage.clickBookStoreButton();
        booksPage.chooseTheBook();

        BookDetailsPage bookDetailsPage = new BookDetailsPage(driver);
        bookDetailsPage.clickAddToYourCollectionButton();
        clickAlert();

        booksPage.clickProfileButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.deleteBook();
        profilePage.confirmDelete();
        clickAlert();
    }
}
