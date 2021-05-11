package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class ParentClass {
    protected WebDriver driver;

    protected ParentClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void scroolToElement(WebElement element) {
//        jse.executeScript("window.scrollBy(0, 801)"); - было во многих классах у вас. Лучше скролить не по размеру экрана, а к элементу, если завтра поменяется расположение кнопки, то тест упадет
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
}
