package pages;

import helpers.ParentClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BookDetailsPage extends ParentClass {
    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    private WebElement addToYourCollectionButton;

    public BookDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToYourCollectionButton() {
        scrollToElement(addToYourCollectionButton);
        addToYourCollectionButton.click();
    }
}
