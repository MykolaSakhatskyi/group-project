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
        ProfilePage profile = new ProfilePage(driver); // Я бы объявлял эти переменные непосредственно перед их вызовом
        LoginPage loginPage = new LoginPage(driver); // а не вначале теста

        mainPage.clickBookStoreApplicationButton();
        profile.openProfilePage();
        profile.loginLinkInProfile();
        loginPage.login();
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
        profile.deleteAllBooksFromProfile();


    }
}
