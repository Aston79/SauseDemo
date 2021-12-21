package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CartPageTest extends BaseTest {

    @Test(description = "Add item to cart and than delete")
    public void addItemToCartAndDeleteIt() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.removeOneItemFromCart();
        Assert.assertEquals(0, cartPage.listOfItems());
    }

    @Test(description = "Add all items to cart and than delete all")
    public void addAllItemsToCartAndRemoveAll() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.listOfItems("");
        cartPage.open();
        cartPage.removeAllItemsFromCart();
        Assert.assertEquals(0, cartPage.listOfItems());
    }
}
