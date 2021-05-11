package pages;

import helpers.ParentClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends ParentClass {

    public static final String USERNAME = "Testic";
    public static final String PASSWORD = "A1234@!z";

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "userName")
    private WebElement userNameField;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='userName']")
    private WebElement userNameFieldEmpty;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "password")
    private WebElement passwordField;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='password']")
    private WebElement passwordFieldEmpty;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "login")
    private WebElement loginButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "name")
    private WebElement errorMassage;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "newUser")
    private WebElement newUserButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait wait = new WebDriverWait(driver,5);

    public void login(String username, String password) {
        ProfilePage profilePage = new ProfilePage(driver);
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(profilePage.getLogoutButton()));
        assertTrue(driver.getCurrentUrl().contains("/profile"));
    }

    public WebElement getUserNameFieldEmpty() {
        return userNameFieldEmpty;
    }

    public WebElement getPasswordFieldEmpty() {
        return passwordFieldEmpty;
    }

    public void waitingErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("name")));
    }

    public WebElement getErrorMassage() {
        return errorMassage;
    }

    public WebElement getNewUserButton() {
        return newUserButton;
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
