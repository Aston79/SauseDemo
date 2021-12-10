package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HerocuDCLocators extends BasePage {

    public HerocuDCLocators(WebDriver driver) {
        super(driver);
    }

    public static final By inputDCLocator = By.xpath("//input[@type='text']");
    public static final By inputDCLocator2 = By.xpath("//*[@id=\"input-example\"]/input");
    public static final By enableDCLocatorButton = By.xpath("(//button[normalize-space()='Enable'])[1]");
    public static final By contentDCLocator = By.xpath("(//p[normalize-space()='Your content goes here.'])[1]");

    public static final String FRAME_ATTRIBUTE = "//p[normalize-space()='Your content goes here.']";
}
