package tests;

import io.qameta.allure.Link;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.AllureUtils;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploaderTest extends BaseTest {

    @Link("https://automated-testing.info/t/zagruzka-fajla-cherez-webdriver/3823")
    @Test(description = "Make upload file to resource")
    public void fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");

        File file = new File("src/test/resources/Frlncr.JPG");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.id("file-submit")).click();
        assertEquals(driver.findElement(By.xpath("//div[@class='example']/h3")).getText(), "File Uploaded!", "File not loaded");
        AllureUtils.takeScreenshot(driver);
    }
}
