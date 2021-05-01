package tests;

import helpers.TextBoxHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TextBoxPositiveTest extends TextBoxHelper {

    @Test
    public void TextBoxFirstTest(){
    WebElement fullName = driver.findElement(By.id("userName"));
    WebElement submitButton= driver.findElement(By.id("submit"));

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    WebElement  resultName = driver.findElement(By.xpath("//button"));

    String resultText = resultName.getAttribute("(\"Name:Ivan Ivanov\"");


    fullName.sendKeys("Ivan Ivanov");
        submitButton.click();

        Assert.assertFalse(Boolean.parseBoolean(resultText));
    }
    

}
