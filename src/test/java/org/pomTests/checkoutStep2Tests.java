package org.pomTests;

import org.DriversFactory;
import org.PomUtility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.SlLoginPage;

public class checkoutStep2Tests {
    private static WebDriver driver;
    private static SlLoginPage loginPage;

    @BeforeAll
    static void setupAll() {
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.CHROME);
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new SlLoginPage(driver);
    }

    @Test
    @DisplayName("Go to Inventory")
    void goToInventoryTest() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().goToInventoryPage().getURL());
    }

    @Test
    @DisplayName("Go to Confirmation")
    void goToConfirmationTest() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().goToConfirmationPage().getURL());

    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}
