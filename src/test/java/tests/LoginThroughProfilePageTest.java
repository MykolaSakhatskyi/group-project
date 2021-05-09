package tests;

import helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class LoginThroughProfilePageTest extends BaseTest {

    @Test
    public void LoginAtProfilePageTest(){
        MainPage mainPage = new MainPage(driver);
        ProfilePage profile = new ProfilePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickBookStoreApplicationButton();
        profile.openProfilePage();
        profile.loginLinkInProfile();
        loginPage.login();

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        WebElement logoutButton = driver.findElement(By.xpath(".//button[contains(text(),'Log out')]"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }
}
