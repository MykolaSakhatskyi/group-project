package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class ParentClass {

    protected WebDriver driver;

    protected ParentClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
