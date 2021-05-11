package pages;

import helpers.ParentClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends ParentClass {

    @FindBy(id = "firstname")
    private WebElement firsNameField;

    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='firstname']")
    private WebElement firsNameFieldEmpty;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='lastname']")
    private WebElement lastNameFieldEmpty;

    @FindBy(id = "userName")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='userName']")
    private WebElement userNameFieldEmpty;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control'][@id='password']")
    private WebElement passwordFieldEmpty;

    @FindBy(id = "register")
    private WebElement registerButton;

    @FindBy(id = "gotologin")
    private WebElement backToLoginButton;

    @FindBy(className = "recaptcha-checkbox-border")
    private WebElement captchaCheckbox;

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
        WebDriver captchaFrame = driver.switchTo().frame(0); // Не понимаю, для чего присваетвается новый драйвер, если он нигде не используется
    }

    public void switchToMainWindow() {
        WebDriver mainWindow = driver.switchTo().parentFrame(); // Не понимаю, для чего присваетвается новый драйвер, если он нигде не используется
    }
}
