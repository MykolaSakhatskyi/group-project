package pages;

import helpers.ParentClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public WebElement getErrorMassage() {
        return errorMassage;
    }
}
