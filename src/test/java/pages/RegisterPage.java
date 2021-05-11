package pages;

import helpers.ParentClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends ParentClass {

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "firstname")
    private WebElement firsNameField;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='firstname']")
    private WebElement firsNameFieldEmpty;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='lastname']")
    private WebElement lastNameFieldEmpty;

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
    @FindBy(id = "register")
    private WebElement registerButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "gotologin")
    private WebElement backToLoginButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(className = "recaptcha-checkbox-border")
    private WebElement captchaCheckbox;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "name")
    private WebElement error;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBackToLoginButton () {
        return backToLoginButton;
    }

    public WebElement getRegisterButton () {
        return registerButton;
    }

    public WebElement getFirsNameFieldEmpty () {
        return firsNameFieldEmpty;
    }

    public WebElement getLastNameFieldEmpty () {
        return lastNameFieldEmpty;
    }

    public WebElement getUserNameFieldEmpty () {
        return userNameFieldEmpty;
    }

    public WebElement getPasswordFieldEmpty () {
        return passwordFieldEmpty;
    }

    public WebElement getError () {
        return error;
    }

    public void setFirsNameField (String firstname) {
        firsNameField.sendKeys(firstname);
    }

    public void setLastNameField (String lastname) {
        lastNameField.sendKeys(lastname);
    }

    public void setUsernameField(String username) {
        userNameField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public WebElement getCaptchaCheckbox () {
        return captchaCheckbox;
    }

    public void switchToCaptchaFrame() {
        driver.switchTo().frame(0);
    }

    public void switchToMainWindow() {
        driver.switchTo().parentFrame();
    }
}
