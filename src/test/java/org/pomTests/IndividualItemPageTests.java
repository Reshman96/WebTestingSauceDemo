package org.pomTests;

import org.PomUtility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.SLCartPage;
import org.pom.SLIndividualItemPage;
import org.pom.SlLoginPage;

public class IndividualItemPageTests {
    private static WebDriver driver;
    private SLIndividualItemPage slIndividualItemPage;
    private static SlLoginPage loginPage;
    private SLCartPage slCartPage;

    @BeforeAll
    static void setupAll() {
        PomUtility.setDriverLocation(PomUtility.getDefaultDriverLocation());
        PomUtility.setChromeDriverService(PomUtility.getDefaultDriverLocation());

    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new SlLoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");
        slIndividualItemPage = new SLIndividualItemPage(driver);
        slCartPage = new SLCartPage(driver);
    }

    @Test
    @DisplayName("Is number on cart badge correct after adding an item")
    void isItemAddedToCart() {
        int itemsBeforeAdding = slIndividualItemPage.getNumberOfCartItems();
        int itemsAfterAdding;
        slIndividualItemPage.addItemToCart();
        itemsAfterAdding = slIndividualItemPage.getNumberOfCartItems();
        Assertions.assertEquals(itemsBeforeAdding + 1, itemsAfterAdding);
    }

    @Test
    @DisplayName("Is number on cart badge correct after removing an item")
    void isItemRemovedFromCart() {
        slIndividualItemPage.addItemToCart();
        int itemsBeforeRemoving = slIndividualItemPage.getNumberOfCartItems();
        int itemsAfterRemoving;
        slIndividualItemPage.removeItemFromCart();
        itemsAfterRemoving = slIndividualItemPage.getNumberOfCartItems();
        Assertions.assertEquals(itemsBeforeRemoving - 1, itemsAfterRemoving);
    }

    @Test
    @DisplayName("CheckBackToProductsButton")
    void CheckBackToProductsButtonTest() {
        slIndividualItemPage.goToInventoryPage();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

    }

    @Test
    @DisplayName("Check go to cart page")
    void checkGoToCartPageTest() {
        slIndividualItemPage.goToCartPage();
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check if added product is in cart")
    void checkIfAddedProductIsInCart() {
        String addedItemName = slIndividualItemPage.getProductName();
        slIndividualItemPage.addItemToCart();
        slIndividualItemPage.goToCartPage();
        Assertions.assertTrue(slCartPage.getItemNameInCart(0).equals(addedItemName));
    }

    @Test
    @DisplayName("Check if product is removed from cart")
    void checkIfProductIsRemovedFromCart() {
        slIndividualItemPage.addItemToCart();
        slIndividualItemPage.removeItemFromCart();
        slIndividualItemPage.goToCartPage();
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> slCartPage.getItemNameInCart(0));

    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
