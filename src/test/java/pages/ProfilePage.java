package pages;

import helpers.ParentClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProfilePage extends ParentClass {
    @FindBy(xpath = ".//span[text()='Profile']")
    private WebElement profileButton;
    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement profileLoginUrl;
    @FindBy(xpath = ".//a[@href='/register']")
    private WebElement profileRegisterUrl;
    @FindBy(xpath = ".//button[@id='gotoStore']")
    private WebElement goToBookstoreButton;
    @FindBy(xpath = ".//div[@class='text-right button di']/child::button")
    private WebElement deleteBooksButton;
    @FindBy(xpath = ".//button[@id='closeSmallModal-ok']")
    private WebElement modalWindowOK;
    @FindBy(xpath = ".//button[@id='gotoStore']")
    private List<WebElement> bookTitle;
    @FindBy(xpath = ".//button[contains(text(),'Add To Your Collection')]")
    private WebElement addToCollection;
    @FindBy(xpath = ".//button[contains(text(),'Back To Book Store')]")
    private WebElement backToBookStoreButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public void openProfilePage() {
        profileButton.click();
    }
    public void loginLinkInProfile(){
        profileLoginUrl.click();
    }
    public void registerInProfile(){
        profileRegisterUrl.click();
    }
    public void goToBookstoreButton(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 400)");
        goToBookstoreButton.click();
    }
    public void deleteAllBooksFromProfile(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 400)");
        deleteBooksButton.click();
        String MainWindow=driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1= s1.iterator();
        while (i1.hasNext())
        {String ChildWindow= i1.next();
            driver.switchTo().window(ChildWindow);
            modalWindowOK.click();
            driver.switchTo().alert().accept();
        }
        driver.switchTo().window(MainWindow);
    }
}
