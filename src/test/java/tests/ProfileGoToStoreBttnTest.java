package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class ProfileGoToStoreBttnTest extends BaseTest {

    @Test
    public void profileButtonGoToStore() {
        new MainPage(driver).clickBookStoreApplicationButton();
        ProfilePage profile = new ProfilePage(driver);
        profile.openProfilePage();
        profile.loginLinkInProfile();
        new LoginPage(driver).login(LoginPage.USERNAME, LoginPage.PASSWORD);
        profile.goToBookstoreButton();

        Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://demoqa.com/books"));
    }
}
