package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class LoginThroughProfilePageTest extends BaseTest {

    @Test
    public void LoginAtProfilePageTest(){
        MainPage mainPage = new MainPage(driver);
        ProfilePage profile = new ProfilePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickBookStoreApplicationButton();
        profile.openProfilePage();
        profile.loginLinkInProfile();
        loginPage.login(LoginPage.USERNAME, LoginPage.PASSWORD);

        Assert.assertTrue(profile.getLogoutButton().isDisplayed());
    }
}
