package org.pomTests;

import org.PomUtility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.SLIndividualItemPage;
import org.pom.SlLoginPage;

public class IndividualItemPageTests {
    private static WebDriver driver;
    private SLIndividualItemPage slIndividualItemPage;
    private static SlLoginPage loginPage;

    @BeforeAll
    static void setupAll(){
        PomUtility.setDriverLocation(PomUtility.getDefaultDriverLocation());
        PomUtility.setChromeDriverService(PomUtility.getDefaultDriverLocation());

    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new SlLoginPage(driver);
        loginPage.Login("standard_user", "secret_sauce");
        slIndividualItemPage = new SLIndividualItemPage(driver);
    }


    @Test
    @DisplayName("Is item added to cart")
    void isItemAddedToCart() {
        int itemsBeforeAdding = slIndividualItemPage.getNumberOfCartItems();
        int itemsAfterAdding;
        slIndividualItemPage.addItemToCart();
        itemsAfterAdding = slIndividualItemPage.getNumberOfCartItems();
        Assertions.assertEquals(itemsBeforeAdding+1, itemsAfterAdding);
    }

    @Test
    @DisplayName("Is item removed from cart")
    void isItemRemovedFromCart() {
        slIndividualItemPage.addItemToCart();
        int itemsBeforeRemoving = slIndividualItemPage.getNumberOfCartItems();
        int itemsAfterRemoving;
        slIndividualItemPage.removeItemFromCart();
        itemsAfterRemoving = slIndividualItemPage.getNumberOfCartItems();
        Assertions.assertEquals(itemsBeforeRemoving-1, itemsAfterRemoving);


    }


    @AfterEach
    void tearDown() {
        driver.close();
    }
}
