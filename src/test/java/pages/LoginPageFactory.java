package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPageFactory extends BasePage{

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    WebElement userNameInput;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@class='bot_column']")
    WebElement botLogo;

    @Step("Login as '{username}' with '{password}'")
    @Description(value = "Valid data login")
    public ProductsPage login(String username, String password) {
        waitForElementLocated(userNameInput, 5);
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public void open(String url) {
        open(URL);
    }

    public void waitForPageOpened() {
        waitForElementLocated(botLogo, 10);
    }
}
