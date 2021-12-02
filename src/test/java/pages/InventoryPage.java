package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {

    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button";
    public static final String ADD_PRODUCT_PRICE = "(//div[@class='inventory_item_price'])[5]";
    public static final String ADD_PRODUCTS_NAME = ".inventory_item_name";
    public static final String ADD_PRODUCT_CART_PRICE = "//div[@class='inventory_item_price']";

    public static final By listOfItems = By.className("inventory_item_name");
    public static final String ITEM_1 = "//div[normalize-space()='Sauce Labs Bolt T-Shirt']";
    public static final String ITEM_2 = "//div[normalize-space()='Sauce Labs Onesie']";

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    public String getPriceByName(String nameProduct) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_PRICE, nameProduct))).getText();
    }

    public String getPriceByNameAtCart(String nameProduct) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_CART_PRICE, nameProduct))).getText();
    }

    public String choseTheItems(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCTS_NAME, nameProduct))).click();
        return nameProduct;
    }

    public int listOfItems(String s) {
        List<WebElement> items = driver.findElements(listOfItems);
        return items.size();
    }

    public String checkTheItem1(String nameProduct) {
        driver.findElement(By.xpath(String.format(ITEM_1, nameProduct)));
        return nameProduct;
    }

    public String checkTheItem2(String nameProduct) {
        driver.findElement(By.xpath(String.format(ITEM_2, nameProduct)));
        return nameProduct;
    }
}
