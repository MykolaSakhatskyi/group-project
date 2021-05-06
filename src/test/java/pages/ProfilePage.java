package pages;

import helpers.ParentClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends ParentClass {
    @FindBy(xpath = "//button[contains(text(),'Log out')]")
    public WebElement logOutButton;

    @FindBy(id = "delete-record-undefined")
    private WebElement deleteButton;

    @FindBy(id = "closeSmallModal-ok")
    private WebElement deleteConfirmButton;
    private WebDriverWait wait = new WebDriverWait(driver,5);

    public void deleteBook() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }

    public void confirmDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmButton));
        deleteConfirmButton.click();
    }

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
