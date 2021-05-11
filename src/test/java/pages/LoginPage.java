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

    @FindBy(id = "userName")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='userName']")
    public WebElement userNameFieldEmpty;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='password']")
    private WebElement passwordFieldEmpty;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "name")
    private WebElement errorMassage;

    @FindBy(id = "newUser")
    private WebElement newUserButton;

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

    public void setUsernameField(String username) {
        userNameField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
