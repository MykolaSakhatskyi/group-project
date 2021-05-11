package pages;

import helpers.ParentClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksPage extends ParentClass {

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//span[text()='Book Store']")
    private WebElement bookStoreButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "see-book-Git Pocket Guide")
    private WebElement gitPocketGuideBook;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//span[text()='Profile']")
    private WebElement profileButton;

    private WebDriverWait wait = new WebDriverWait(driver, 5);

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public void clickBookStoreButton() {
        scrollToElement(bookStoreButton);
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
