package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

import static org.testng.Assert.assertEquals;
import static pages.HerocuDCLocators.FRAME_ATTRIBUTE;

public class FramesTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Check the frames assertion")
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

    @Test(description = "Check the content assertion")
    public void content2Test() {

        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).click();
        Assert.assertEquals(driver.findElement(By.xpath(FRAME_ATTRIBUTE)).getText(), "Your content goes here.", "********  Incorrect assertion  *******");

    }

}
