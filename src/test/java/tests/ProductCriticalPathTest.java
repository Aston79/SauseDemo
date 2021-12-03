package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pages.CartPage.*;
import static pages.InventoryPage.*;

public class ProductCriticalPathTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCard() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        String price = inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        assertEquals(driver.findElement(By.cssSelector(PRODUCT_PRICE_IN_THE_CART)).getText(), price, "Prices are not equal");
    }

    @Test
    public void userDataFieldForContinueShopping() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutClickButton();
        Thread.sleep(100);
        Assert.assertFalse(false, "You are can`t continue shopping");
    }

    @Test
    public void checkTheItemNameInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        assertEquals(driver.findElement(By.cssSelector(PRODUCT_NAME_IN_THE_CART)).getText(), "Sauce Labs Onesie", "Item names not matched");
    }

    @Test
    public void checkTheItemPriceInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        String price = inventoryPage.getPriceByName("Sauce Labs Onesie");
        cartPage.open();
        assertEquals(driver.findElement(By.xpath(ADD_PRODUCT_CART_PRICE)).getText(), price, "Item prices not matched");
    }

    @Test
    public void checkItemNameTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(ITEM_1, ITEM_2, "Chosen items not the same");
    }
}
