package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void addItemToCartAndDeleteIt() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.removeOneItemFromCart();
        Assert.assertEquals(0, cartPage.listOfItems());
    }

    @Test
    public void addAllItemsToCartAndRemoveAll() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage. listOfItems("");
        cartPage.open();
        cartPage.removeAllItemsFromCart();
        Assert.assertEquals(0, cartPage.listOfItems());
    }
}
