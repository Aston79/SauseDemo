package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public static final String URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Opening URL: '{url}'")
    @Description(value = "Open base URL https://www.saucedemo.com/")
    public void open(String url) {
        log.info("Open url");
        driver.get(url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForElementLocated(By element, int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementLocated(WebElement element, int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
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
