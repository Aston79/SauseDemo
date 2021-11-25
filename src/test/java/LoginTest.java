import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginTesting() {
        driver.get("https://www.saucedemo.com/");

        WebElement userNameInput = driver.findElement(By.name("user-name"));
        userNameInput.sendKeys("standard_user");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();

        List<WebElement> priceElements = driver.findElements(By.cssSelector(".inventory_item_price"));
        String textFromPriceLabel = priceElements.get(0).getText();
        assertEquals(textFromPriceLabel, "$29.99", "the cost does not match");
    }
}
