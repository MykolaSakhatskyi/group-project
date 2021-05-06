package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;

public class RegistrationURLTest extends BaseTest {

    @Test
    public void registerURLinProfile() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profile = new ProfilePage(driver);

        mainPage.clickBookStoreApplicationButton();
        profile.openProfilePage();
        profile.registerInProfile();
        Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://demoqa.com/register"));
    }
}
