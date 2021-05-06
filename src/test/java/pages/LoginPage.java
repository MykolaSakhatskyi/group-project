package pages;

import helpers.ParentClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends ParentClass {

    @FindBy(id = "userName")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait wait = new WebDriverWait(driver,5);

    public void login() {
        ProfilePage profilePage = new ProfilePage(driver);
        userNameField.sendKeys("Testic");
        passwordField.sendKeys("A1234@!z");
        loginButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(profilePage.logOutButton));
        assertTrue(driver.getCurrentUrl().contains("/profile"));
    }
}
