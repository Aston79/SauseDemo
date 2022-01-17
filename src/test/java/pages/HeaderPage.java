package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HeaderPage  extends BasePage{

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    private static final By OPEN_POP_UP_MENU = By.xpath("//*[@id='react-burger-menu-btn']");
    private static final By LOG_OUT = By.xpath("//*[@id='logout_sidebar_link']");
    private static final By POP_UP_MENU_ITEMS = By.xpath("//*[@class='bm-menu-wrap']");

    public void waitForPageOpened() {
        waitForElementLocated(POP_UP_MENU_ITEMS, 10);
    }

    @Step("Pop-up menu opening")
    @Description("Pop-up menu opening on the header")
    public HeaderPage openPopUpMenu(){
        waitForPageOpened();
        driver.findElement(OPEN_POP_UP_MENU).click();
        return this;
    }

    public boolean isPopUpMenuDisplayed(){
        return driver.findElement(POP_UP_MENU_ITEMS).isDisplayed();
    }

    @Step("Click on the button: {'LOG_OUT'}")
    @Description(value = "Click on the button to logout")
    public void clickLogOutButton(){
        driver.findElement(LOG_OUT).click();
    }
}
