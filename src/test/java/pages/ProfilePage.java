package pages;

import helpers.ParentClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProfilePage extends ParentClass {
    @FindBy(xpath = "//button[contains(text(),'Log out')]")
    public WebElement logOutButton; // public -> private
    @FindBy(id = "delete-record-undefined")
    private WebElement deleteButton;
    @FindBy(id = "closeSmallModal-ok")
    private WebElement deleteConfirmButton;
    private final WebDriverWait wait = new WebDriverWait(driver,5);
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
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 800)"); // Лучше скролить не по размеру экрана, а к элементу, если завтра поменяется расположение кнопки, то тест упадет.
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
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 400)"); // Лучше скролить не по размеру экрана, а к элементу, если завтра поменяется расположение кнопки, то тест упадет.
        goToBookstoreButton.click();
    }
    public void deleteAllBooksFromProfile(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 800)"); // Лучше скролить не по размеру экрана, а к элементу, если завтра поменяется расположение кнопки, то тест упадет.
        deleteBooksButton.click();
        String MainWindow=driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1= s1.iterator();
        while (i1.hasNext()) // лучше использовать forEach, IntelliJ IDEA подсказывает об этом сама
        {String ChildWindow= i1.next();
            driver.switchTo().window(ChildWindow);
            modalWindowOK.click();
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        }
        driver.switchTo().window(MainWindow);
    }

}
