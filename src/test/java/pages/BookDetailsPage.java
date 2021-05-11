package pages;

import helpers.ParentClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BookDetailsPage extends ParentClass {
    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    private WebElement addToYourCollectionButton;

    public BookDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToYourCollectionButton() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 801)"); // Перед тем как скролить, я бы сделал проверку на то, что кнопка видима, нет смысла выполнять это действие, если у нас сайт открыт на весь экран и кнопка видна
        addToYourCollectionButton.click();
    }
}
