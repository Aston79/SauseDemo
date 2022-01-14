package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.AllureUtils;

import static org.testng.Assert.assertEquals;
import static pages.CartPage.PRODUCT_NAME_IN_THE_CART;
import static pages.CartPage.PRODUCT_PRICE_IN_THE_CART;
import static pages.InventoryPage.ADD_PRODUCT_CART_PRICE;

public class ProductCriticalPathTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"stanser", "secce", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test (dataProvider = "loginData", description = "Check the login data and error messages")
    public void negativeLoginTest(String userName, String password, String errorMessage){
        loginPage.open();
        loginPage.login(userName,password);
        Assert.assertEquals(loginPage.getErrorMessage(), errorMessage, "Error Message is invalid");
        AllureUtils.takeScreenshot(driver);
    }

    @Link("https://docs.qameta.io/allure/#_testng")
    @Issue("456")
    @TmsLink("taskLink")
    @Test(description = "Product should be added to cart")
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        String price = inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        assertEquals(driver.findElement(By.cssSelector(PRODUCT_PRICE_IN_THE_CART)).getText(), price, "Prices are not equal");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Fill user data field for shopping continue")
    public void userDataFieldForContinueShopping() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutClickButton();
        Thread.sleep(100);
        Assert.assertFalse(false, "You are can`t continue shopping");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Checking the item name in the cart")
    public void checkTheItemNameInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        assertEquals(driver.findElement(By.cssSelector(PRODUCT_NAME_IN_THE_CART)).getText(), "Sauce Labs Onesie", "Item names not matched");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Checking the item price in the cart")
    public void checkTheItemPriceInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        String price = inventoryPage.getPriceByName("Sauce Labs Onesie");
        cartPage.open();
        assertEquals(driver.findElement(By.xpath(ADD_PRODUCT_CART_PRICE)).getText(), price, "Item prices not matched");
        AllureUtils.takeScreenshot(driver);
    }

}

