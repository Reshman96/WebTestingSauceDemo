package org.pomTests;

import org.PomUtility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.SlLoginPage;

public class checkoutStep1Tests {
    private static WebDriver driver;
    private static SlLoginPage loginPage;

    @BeforeAll
    static void setupAll() {
        PomUtility.setDriverLocation(PomUtility.getDefaultDriverLocation());
        PomUtility.setChromeDriverService(PomUtility.getDefaultDriverLocation());
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new SlLoginPage(driver);
    }

    @Test
    @DisplayName("Go to Cart")
    void goToCartTest() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page().goToCart().getURL());
    }

    @Test
    @DisplayName("Go to Checkout Step 2")
    void goToCheckoutStep2Test() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().getURL());
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
