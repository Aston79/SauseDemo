package pages;

import io.qameta.allure.Link;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class BasePage {
    WebDriver driver;

    public static final String URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Link("https://docs.google.com/presentation/d/1nfqmUEuj7h-nyH6d0g8ZnPiBblN-CuelzkBCubuO8AY/edit#slide=id.g9de17bf251_0_0")
    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }
}
