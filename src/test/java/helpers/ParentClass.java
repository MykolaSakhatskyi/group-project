package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class ParentClass { // ParentClass - не очень хорошее название, родительский класс чего? Лучше назвать ParentPageClass или BasePage
    protected WebDriver driver;

    protected ParentClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
