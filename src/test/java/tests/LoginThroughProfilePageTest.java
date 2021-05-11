package tests;

import helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // лишние импорты
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; // лишние импорты
import org.openqa.selenium.support.ui.ExpectedCondition; // лишние импорты
import org.openqa.selenium.support.ui.ExpectedConditions; // лишние импорты
import org.openqa.selenium.support.ui.WebDriverWait; // лишние импорты
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class LoginThroughProfilePageTest extends BaseTest {

    @Test
    public void LoginAtProfilePageTest(){
        MainPage mainPage = new MainPage(driver); // mainPage используется лишь раз, можно не выносить ее в отдельную переменную
        ProfilePage profile = new ProfilePage(driver);
        LoginPage loginPage = new LoginPage(driver); // loginPage используется лишь раз, можно не выносить ее в отдельную переменную

        mainPage.clickBookStoreApplicationButton();
        profile.openProfilePage();
        profile.loginLinkInProfile();
        loginPage.login();

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS); // implicitlyWait снова, его не нужно так использовать, он не для явных ожиданий :)
        WebElement logoutButton = driver.findElement(By.xpath(".//button[contains(text(),'Log out')]"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }
}
