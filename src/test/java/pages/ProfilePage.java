package pages;

import helpers.ParentClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class ProfilePage extends ParentClass {
    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = "//button[contains(text(),'Log out')]")
    private WebElement logOutButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "delete-record-undefined")
    private WebElement deleteButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(id = "closeSmallModal-ok")
    private WebElement deleteConfirmButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//span[text()='Profile']")
    private WebElement profileButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement profileLoginUrl;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//a[@href='/register']")
    private WebElement profileRegisterUrl;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//button[@id='gotoStore']")
    private WebElement goToBookstoreButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//div[@class='text-right button di']/child::button")
    private WebElement deleteBooksButton;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//button[@id='closeSmallModal-ok']")
    private WebElement modalWindowOK;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//button[@id='gotoStore']")
    private List<WebElement> bookTitle;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//button[contains(text(),'Add To Your Collection')]")
    private WebElement addToCollection;

    @SuppressWarnings({"unused", "using for page factory"})
    @FindBy(xpath = ".//button[contains(text(),'Back To Book Store')]")
    private WebElement backToBookStoreButton;

    private final WebDriverWait wait = new WebDriverWait(driver,5);

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void openProfilePage() {
        scrollToElement(profileButton);
        profileButton.click();
    }
    public void deleteBook() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }

    public void confirmDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmButton));
        deleteConfirmButton.click();
    }

    public void loginLinkInProfile(){
        profileLoginUrl.click();
    }
    public void registerInProfile(){
        profileRegisterUrl.click();
    }
    public void goToBookstoreButton(){
        scrollToElement(goToBookstoreButton);
        goToBookstoreButton.click();
    }
    public void deleteAllBooksFromProfile(){
        scrollToElement(deleteBooksButton);
        deleteBooksButton.click();
        String MainWindow=driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();
        for (String ChildWindow : s1) {
            driver.switchTo().window(ChildWindow);
            modalWindowOK.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        }
        driver.switchTo().window(MainWindow);
    }

    public WebElement getLogoutButton() {
        return logOutButton;
    }

}
