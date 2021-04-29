package pages;

import helpers.ParentClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends ParentClass {

    @FindBy(xpath ="//span[text()='Login']")
    private WebElement loginButton;

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public void setLoginButton() {
        loginButton.click();
    }
}
