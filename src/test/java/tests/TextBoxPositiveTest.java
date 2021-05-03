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
    WebElement email = driver.findElement(By.id("userEmail"));
    WebElement currentAddress = driver.findElement(By.id("currentAddress"));
    WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
    WebElement submitButton= driver.findElement(By.id("submit"));

    fullName.sendKeys("Ivan Ivanov");
    email.sendKeys("ivanov@gmail.com");
    currentAddress .sendKeys("Kyiv");
    permanentAddress.sendKeys("London");
    submitButton.click();

    WebElement resultName = driver.findElement(By.xpath("//p[@id='name']"));
    WebElement resultEmail = driver.findElement(By.xpath("//p[@id='email']"));
    WebElement resultCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
    WebElement resultPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

    String resultText1 = resultName.getAttribute("(\"Name:Ivan Ivanov\"");
    String resultText2 = resultEmail.getAttribute("(\"Email:ivanov@gmail.com\"");
    String resultText3 = resultCurrentAddress.getAttribute("(\"Current Address :Kyiv\"");
    String resultText4 = resultPermanentAddress.getAttribute("(\"Permanent Address :London\"");


     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    Assert.assertFalse(Boolean.parseBoolean(resultText1));
    Assert.assertFalse(Boolean.parseBoolean(resultText2));
    Assert.assertFalse(Boolean.parseBoolean(resultText3));
    Assert.assertFalse(Boolean.parseBoolean(resultText4));
    }


}
