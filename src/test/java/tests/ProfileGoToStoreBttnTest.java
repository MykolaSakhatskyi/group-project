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
        ProfilePage profile = new ProfilePage(driver); // Я бы объявлял эти переменные непосредственно перед их вызовом
        LoginPage loginPage = new LoginPage(driver); // а не вначале теста

        mainPage.clickBookStoreApplicationButton();
        profile.openProfilePage();
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS); // почему здесь задается implicitlyWait? Если необходимо явное ожидание то нужно использовать WebDriverWait. implicitlyWait - задает ожидание для всего теста
        profile.loginLinkInProfile();
        loginPage.login();
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS); // уже не нужно его писать, так как две строчки выше implicitlyWait был задан, по факту меняется 3 на 3 :)
        profile.goToBookstoreButton();

        Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://demoqa.com/books"));
    }
}
