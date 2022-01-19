package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SLIndividualItemPage extends Page {
    private WebDriver driver;
    private By addToCartButton = new By.ById("add-to-cart-sauce-labs-backpack");
    private By removeButton = new By.ById("remove-sauce-labs-backpack");
    private By shoppingCart = new By.ByClassName("shopping_cart_badge");
    private By productName = new By.ByClassName("inventory_details_name large_size");
    private By productDescription = new By.ByClassName("inventory_details_desc large_size");
    private By productPrice = new By.ByClassName("inventory_details_price");
    private By backToProductsButton = new By.ById("back-to-products");

    public SLIndividualItemPage(WebDriver driver) {
        this.driver = driver;
    }


    String getURL() {
        return driver.getCurrentUrl();
    }

}
