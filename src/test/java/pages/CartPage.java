package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    public static final String TITLE_NAME = "//span[normalize-space()='Products']";
    public static final String PRODUCT_IN_THE_CART = ".inventory_item_name";
    public static final String PRODUCT_CART_PRICE = "(//div[@class='inventory_details_price'])[1]";
    public static final String CHECKOUT_BUTTON = "checkout";

    public static final String REMOVE_BUTTON = "remove-sauce-labs-onesie";
    public static final By listOfItems = By.xpath("//div[@class='cart_item']");
    public static final By removeButtons = By.xpath("//button[@class='btn_secondary cart_button']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public int listOfItems() {
        List<WebElement> items = driver.findElements(listOfItems);
        return items.size();
    }

    public void getItemsNameInTheCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(PRODUCT_IN_THE_CART, nameProduct)));
    }

    public String getProductCartPrice(String nameProduct) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CART_PRICE, nameProduct))).getText();
    }

    public void checkoutClickButton() {
        driver.findElement(By.id(CHECKOUT_BUTTON)).click();
    }

    public void removeOneItemFromCart() {
        driver.findElement(By.id(REMOVE_BUTTON)).click();
    }

    public void removeAllItemsFromCart() {
        List<WebElement> removeButtonsList = driver.findElements(removeButtons);
        for (int i = 0; i < removeButtonsList.size(); i++) {
            removeButtonsList.get(i).click();
        }
    }
}
