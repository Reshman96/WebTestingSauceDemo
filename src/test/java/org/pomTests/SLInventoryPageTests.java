package org.pomTests;

import org.DriversFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.SlLoginPage;
import org.pom.inventoryPage.FilterOptions;

public class SLInventoryPageTests {

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

    @Nested
    @DisplayName("Inventory Page Tests")
    class InventoryPageTests {
        @Test
        @DisplayName("Can we open the basket test")
        void navigateToBasketTest() {
            Assertions.assertEquals("https://www.saucedemo.com/cart.html", loginPage.Login("standard_user", "secret_sauce").goToCart().getURL());
        }

        @Test
        @DisplayName("Can we open an individual item test")
        void navigateToIndividualItemTest() {
            //This says id = 4, but that is because of the base filter being a-z.
            Assertions.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", loginPage.Login("standard_user", "secret_sauce").goToItem(0).getURL());
        }

        @Test
        @DisplayName("Can we filter items test")
        void filterItemsTest() {
            //This says id = 3, but that is because of the filter being z-a.
            Assertions.assertEquals("https://www.saucedemo.com/inventory-item.html?id=3", loginPage.Login("standard_user", "secret_sauce")
                    .openFilterAccordian()
                    .chooseFilterOption(FilterOptions.Z_TO_A)
                    .goToItem(0).getURL());
        }

        @Test
        @DisplayName("Can we add items to the basket?")
        void addItemToBasket() {
            Assertions.assertEquals("Sauce Labs Backpack", loginPage.Login("standard_user", "secret_sauce")
                    .addToCart(0)
                    .goToCart()
                    .getItemNameInCart(0));
        }

        @Test
        @DisplayName("Can we remove items from the basket?")
        void removeItemFromBasket() {
            //Funnily enough, addtocart and removefromcart are the same, as they both press the same button.
            Assumptions.assumeTrue(loginPage.Login("standard_user", "secret_sauce")
                    .addToCart(0)
                    .goToCart()
                    .getItemNameInCart(0).equals("Sauce Labs Backpack" ));
            Assertions.assertThrows(NoSuchElementException.class, () -> loginPage.Login("standard_user", "secret_sauce")
                    .removeFromCart(0)
                    .goToCart()
                    .getItemNameInCart(0));
        }
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}
