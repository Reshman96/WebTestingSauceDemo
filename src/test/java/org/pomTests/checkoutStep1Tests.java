package org.pomTests;

import org.DriversFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.SLCheckoutStep1Page;
import org.pom.SlLoginPage;

public class checkoutStep1Tests {
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
    @DisplayName("Go to Cart")
    void goToCartTest() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page().goToCart().getURL());
    }

    @Test
    @DisplayName("Go to Checkout Step 2")
    void goToCheckoutStep2Test() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().getURL());
    }

    @Test
    @DisplayName("Shows Error: First Name is required")
    void firstNameIsRequiredError() {
        SLCheckoutStep1Page checkoutStep1Page = loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page();
        checkoutStep1Page.setLastName("Big Tuna");
        checkoutStep1Page.setPostalCode("0121");
        checkoutStep1Page.clickContinueButton();
        Assertions.assertEquals("Error: First Name is required", driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText());
    }

    @Test
    @DisplayName("Shows Error: Last Name is required")
    void lastNameIsRequiredError() {
        SLCheckoutStep1Page checkoutStep1Page = loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page();
        checkoutStep1Page.setFirstName("Luciano");
        checkoutStep1Page.setPostalCode("0122");
        checkoutStep1Page.clickContinueButton();
        Assertions.assertEquals("Error: Last Name is required", driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText());
    }

    @Test
    @DisplayName("Shows Error: Postal Code is required")
    void postalCodeIsRequiredError() {
        SLCheckoutStep1Page checkoutStep1Page = loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page();
        checkoutStep1Page.setFirstName("Tommy");
        checkoutStep1Page.setLastName("T");
        checkoutStep1Page.clickContinueButton();
        Assertions.assertEquals("Error: Postal Code is required", driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText());
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
