package tests;

import helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        loginPage.login(LoginPage.USERNAME, LoginPage.PASSWORD);
        loginPage.clickLoginButton();

        WebElement profilePageName = driver.findElement(By.className("main-header"));
        Assert.assertTrue(profilePageName.isDisplayed(),"Profile page was not opened");
    }
}
