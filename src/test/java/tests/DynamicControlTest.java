package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static pages.HerocuDCLocators.*;

public class DynamicControlTest extends BaseTest {


    @Test(description = "Dynamic control")
    public void dynamicControl() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//div[@id='checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Remove'])[1]")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("message"));

        WebElement inputDisabled = driver.findElement(inputDCLocator);
        assertFalse(inputDisabled.isEnabled(), "Input available");
        WebElement enableButton = driver.findElement(enableDCLocatorButton);
        enableButton.click();

        driver.findElement(By.xpath(("//*[@id=\"input-example\"]/button"))).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='message']"));

        WebElement inputDisabled2 = driver.findElement(inputDCLocator2);
        assertTrue(inputDisabled2.isEnabled(), "Input available");
    }
}

