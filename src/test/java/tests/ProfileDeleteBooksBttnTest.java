package tests;

import helpers.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class ProfileDeleteBooksBttnTest extends BaseTest {

    @Test
    public void deleteBooksButtonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBookStoreApplicationButton();

        ProfilePage profile = new ProfilePage(driver);
        profile.openProfilePage();
        profile.loginLinkInProfile();

        new LoginPage(driver).login(LoginPage.USERNAME, LoginPage.PASSWORD);
        profile.deleteAllBooksFromProfile();


    }
}
