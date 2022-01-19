package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SLIndividualItemPage extends SitePage {
    private WebDriver driver;
    private By addToCartButton = new By.ByCssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private By removeButton = new By.ByCssSelector(".btn.btn_secondary.btn_small.btn_inventory");
    private By shoppingCart = new By.ByClassName("shopping_cart_badge");
    private By productName = new By.ByClassName("inventory_details_name large_size");
    private By productDescription = new By.ByClassName("inventory_details_desc large_size");
    private By productPrice = new By.ByClassName("inventory_details_price");
    private By backToProductsButton = new By.ById("back-to-products");

    public SLIndividualItemPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        driver.get("https://www.saucedemo.com/inventory-item.html?id=4");
    }

    public SLInventoryPage goToInventoryPage(){
        driver.findElement(backToProductsButton).click();
        return new SLInventoryPage(driver);
    }

    public SLCartPage goToCartPage(){
        driver.findElement(shoppingCart).click();
        return new SLCartPage(driver);
    }

    public void removeItemFromCart(){
        driver.findElement(removeButton).click();
    }

    public void addItemToCart(){
        driver.findElement(addToCartButton).click();
    }

    public int getNumberOfCartItems(){
        int numberOfElements = 0;
        List<WebElement> itemsInCart = driver.findElements(shoppingCart);
        for (WebElement ignored : itemsInCart){
            numberOfElements++;
        }
        return numberOfElements;
    }

    public void productInfo(){

    }
}
