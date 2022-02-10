package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pom.inventoryPage.SLInventoryPage;

public class SLIndividualItemPage extends SitePage {
    private final WebDriver driver;
    private final By addItemToCart = new By.ByCssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private final By removeItemFromCart = new By.ByCssSelector(".btn.btn_secondary.btn_small.btn_inventory");
    private final By productName = new By.ByCssSelector(".inventory_details_name.large_size");
    private final By productDescription = new By.ByCssSelector(".inventory_details_desc.large_size");
    private final By productPrice = new By.ByClassName("inventory_details_price");
    private final By goToCart = new By.ByClassName("shopping_cart_link");
    private final By goToInventory = new By.ById("back-to-products");

    public SLIndividualItemPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SLInventoryPage goToInventoryPage(){
        driver.findElement(goToInventory).click();
        return new SLInventoryPage(driver);
    }

    public SLCartPage goToCartPage(){
        driver.findElement(goToCart).click();
        return new SLCartPage(driver);
    }

    public void removeItemFromCart(){
        driver.findElement(removeItemFromCart).click();
    }

    public void addItemToCart(){
        driver.findElement(addItemToCart).click();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public String getProductDescription(){
        return driver.findElement(productDescription).getText();
    }

    public String getProductPrice(){
        return driver.findElement(productPrice).getText();
    }

    public String getAllProductInformation(){
        StringBuilder description = new StringBuilder();
        description.append(driver.findElement(By.className("inventory_details_desc_container")).getText());
        return description.replace(description.length()-12, description.length(), "").toString();
    }
}
