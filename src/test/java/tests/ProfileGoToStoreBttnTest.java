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
        MainPage mainPage = new MainPage(driver);
        ProfilePage profile = new ProfilePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickBookStoreApplicationButton();
        profile.openProfilePage();
        profile.loginLinkInProfile();
        loginPage.login();
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
        profile.goToBookstoreButton();

        Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://demoqa.com/books"));
    }
}
