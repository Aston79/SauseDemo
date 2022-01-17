package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage{

    public static final By USERNAME_INPUT = By.cssSelector("[placeholder='Username']");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector(".error-message-container");
    public static final By BOT_LOGO = By.xpath("//*[@class='bot_column']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening site")
    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        waitForPageLoaded();
        return this;
    }

    @Step("Login as user '{userName}' use password '{password}'")
    @Description(value = "Login with valid data")
    public ProductsPage login(String userName, String password) {
        waitForElementLocated(USERNAME_INPUT, 5);
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Get error message")
    @Description(value = "Get incorrect login error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    public void waitForPageOpened() {
        waitForElementLocated(BOT_LOGO, 5);
    }
}
