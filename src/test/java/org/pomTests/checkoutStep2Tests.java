package org.pomTests;

import org.DriversFactory;
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

    @AfterAll
    static void tearDownAll() {
        driver.quit();
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

    @Test
    @DisplayName("Go to individual page and click item 1")
    void goToIndividualPageAndClickItem1() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory-item.html?id=0", loginPage.Login("standard_user", "secret_sauce").addToCart(1).goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().goToIndividualItemPage(0).getURL());
    }

    @Test
    @DisplayName("Go to individual page and click item 2")
    void goToIndividualPageAndClickItem2() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory-item.html?id=1", loginPage.Login("standard_user", "secret_sauce").addToCart(1).addToCart(2).goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().goToIndividualItemPage(1).getURL());
    }

    @Test
    @DisplayName("Go to individual page and click item 2, should throw exception")
    void goToIndividualPageAndClickItem2ShouldThrowException() {
        Assertions.assertThrowsExactly(IndexOutOfBoundsException.class, () -> loginPage.Login("standard_user", "secret_sauce").addToCart(1).goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().goToIndividualItemPage(1).getURL());
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
