package tests.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)

@Log4j2
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected LoginPageFactory loginPageFactory;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected HeaderPage headerPage;
    protected WebDriverWait wait;

    @Parameters({"browser"})
    @BeforeMethod(description = "Setup and start browser")
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        log.info("Test starting");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();

        testContext.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);

        loginPageFactory = new LoginPageFactory(driver);

        inventoryPage = new InventoryPage(driver);

        cartPage = new CartPage(driver);

        headerPage = new HeaderPage(driver);

    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
        log.info("Test finishing");
    }
}
