import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class FindWebElement extends BaseTest {

    @Test
    public void findWebElement() {

        driver.get("https://www.saucedemo.com/");

        WebElement userNameInput = driver.findElement(By.name("user-name"));

        WebElement passwordInput = driver.findElement(By.id("password"));

        WebElement loginButton = driver.findElement(By.className("input_error form_input"));

        WebElement addToCartButton = driver.findElement(By.tagName("remove-sauce-labs-backpack"));

        WebElement inventoryItemPriceLabel = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));

        WebElement inventoryItemNameLabel = driver.findElement(By.linkText("//*[@id=\"item_4_title_link\"]/div"));

        List<WebElement> priceElements = driver.findElements(By.cssSelector(".inventory_item_price"));
        String textFromPriceLabel = priceElements.get(0).getText();
        assertEquals(textFromPriceLabel, "$29.99", "стоимость не совпадает");

        WebElement elementAttribute = driver.findElement(By.xpath("//tag[@attribute='value']"));

        WebElement elementText = driver.findElement(By.xpath("//tag[text()='text']"));

        WebElement elementContainsAttr = driver.findElement(By.xpath("//tag[contains(@attribute,'text')]"));

        WebElement elementContainsText = driver.findElement(By.xpath("//tag[contains(text(),'text')]"));

        WebElement elementAncestor = driver.findElement(By.xpath("//*[text()='Enterprise Testing']//ancestor::div"));

//------------------------------------------------------

        WebElement elementCssClass = driver.findElement(By.cssSelector(".class\n"));

        WebElement elementCssClass1_2 = driver.findElement(By.cssSelector(".class1.class2\n"));

        WebElement elementCssId = driver.findElement(By.cssSelector("#id"));

        WebElement elementCssTagName = driver.findElement(By.cssSelector("tagname"));

        WebElement elementCssTagNameClass = driver.findElement(By.cssSelector("tagname.class"));

        WebElement elementCssAttribute = driver.findElement(By.cssSelector("[attribute=value]"));


    }
}
