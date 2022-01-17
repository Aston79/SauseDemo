package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class HeaderTest extends BaseTest {
    @Test(description = "Opening pop up menu test")
    public void popUpMenuIsOpened() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .openPopUpMenu();
        Assert.assertTrue(headerPage.isPopUpMenuDisplayed());
    }

    @Test(description = "Logout from account test")
    public void logOutFromAccountTest() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .openPopUpMenu()
                .clickLogOutButton();
        Assert.assertEquals(loginPage.getUrl(), "https://www.saucedemo.com/");
    }
}
