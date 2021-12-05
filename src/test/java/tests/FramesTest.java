package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pages.HerocuDCLocators.FRAME_ATTRIBUTE;
import static pages.HerocuDCLocators.contentDCLocator;

public class FramesTest extends BaseTest {

    @Test
    public void contentTest() {

        this.driver.get("https://the-internet.herokuapp.com/nested_frames");
        this.driver.switchTo().frame("frame-top");
        this.driver.switchTo().frame("frame-left");
        assertEquals("LEFT", this.driver.findElement(By.tagName("body")).getText());
        this.driver.switchTo().parentFrame();
        this.driver.switchTo().frame("frame-middle");
        assertEquals("MIDDLE", this.driver.findElement(By.tagName("body")).getText());
        this.driver.switchTo().parentFrame();
        this.driver.switchTo().frame("frame-right");
        assertEquals("RIGHT", this.driver.findElement(By.tagName("body")).getText());
        this.driver.switchTo().defaultContent();
        this.driver.switchTo().frame("frame-bottom");
        assertEquals("BOTTOM", this.driver.findElement(By.tagName("body")).getText());
    }

    @Test
    public void content2Test() {

        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).click();
        Assert.assertEquals(driver.findElement(By.xpath(FRAME_ATTRIBUTE)).getText(), "Your content goes here.", "********  Incorrect assertion  *******");

    }
}
