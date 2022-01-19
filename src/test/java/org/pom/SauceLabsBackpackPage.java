package org.pom;

import org.openqa.selenium.By;

public class SauceLabsBackpackPage {
    private By addToCartButton = new By.ById("add-to-cart-sauce-labs-backpack");
    private By removeButton = new By.ById("remove-sauce-labs-backpack");
    private By shoppingCart = new By.ByClassName("shopping_cart_badge");
    private By productName = new By.ByClassName("inventory_details_name large_size");
    private By productDescription = new By.ByClassName("inventory_details_desc large_size");
    private By productPrice = new By.ByClassName("inventory_details_price");
    private By backToProductsButton = new By.ById("back-to-products");
}
