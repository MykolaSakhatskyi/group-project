package pages;

import helpers.ParentClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsernameField(String username) {
        userNameField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public WebElement getUserNameFieldEmpty() {
        return userNameFieldEmpty;
    }

    public WebElement getPasswordFieldEmpty() {
        return passwordFieldEmpty;
    }

    public void error() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("name")));
    }

    public WebElement getErrorMassage() {
        return errorMassage;
    }
}
