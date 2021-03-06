package pages;

import helpers.ParentClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksPage extends ParentClass {

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[text()='Book Store']")
    private WebElement bookStoreButton;

    @FindBy(id = "see-book-Git Pocket Guide")
    private WebElement gitPocketGuideBook;

    @FindBy(xpath = "//span[text()='Profile']")
    private WebElement profileButton;

    private WebDriverWait wait = new WebDriverWait(driver,5);

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public void clickBookStoreButton() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 801)");
        bookStoreButton.click();
    }

    public void chooseTheBook() {
        wait.until(ExpectedConditions.elementToBeClickable(gitPocketGuideBook));
        gitPocketGuideBook.click();
    }

    public void clickProfileButton() {
        profileButton.click();
    }
}
