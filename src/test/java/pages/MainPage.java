package pages;

import helpers.ParentClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentClass {
    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//h5[text()='Book Store Application']")
    private WebElement bookStoreApplicationButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickBookStoreApplicationButton() {
        scrollToElement(bookStoreApplicationButton);
        bookStoreApplicationButton.click();
    }
}
