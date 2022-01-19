package org.pomTests;

import org.PomUtility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.*;
import org.pom.inventoryPage.SLInventoryPage;

public class NavigationTests {

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
    @DisplayName("Navigate From Start to End and Back")
    void navigationTests() {
        //login
        SLInventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");

        SLCartPage cartPage = inventoryPage.goToCart();

        SLCheckoutStep1Page checkoutStep1Page = cartPage.goToCheckoutStep1Page();

        SLCheckoutStep2Page checkoutStep2Page = checkoutStep1Page.goToCheckoutStep2Page();

        SLConfirmationOfOrderPage confirmationPage = checkoutStep2Page.goToConfirmationPage();

        inventoryPage = confirmationPage.returnToInventoryPage();

        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getURL());
    }


    @AfterAll
    static void teardownAll() {
        driver.quit();
    }
}
