package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.AllureUtils;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {

    @Test(description = "Context menu assertion")
    public void contextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.id("hot-spot"))).build().perform();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "You selected a context menu", "Текст алерта не корректен");
        alert.dismiss();
        driver.findElement(By.id("hot-spot"));
        AllureUtils.takeScreenshot(driver);
    }
}
