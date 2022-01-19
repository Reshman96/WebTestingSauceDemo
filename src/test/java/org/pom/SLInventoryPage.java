package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SLInventoryPage extends SitePage{
    private WebDriver driver;

    public SLInventoryPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    public SLIndividualItemPage goToItem(int itemNo) {
        driver.findElements(By.className("inventory_item")).get(itemNo).findElement(By.className("inventory_item_name")).click();
        return new SLIndividualItemPage(driver);
    }

    public SLInventoryPage addToCart(int itemNo) {
        driver.findElements(By.className("inventory_item")).get(itemNo).findElement(By.className("btn_inventory")).click();
        return this;
    }

    public SLCartPage goToCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
        return new SLCartPage(driver);
    }

    public WebElement getInventoryElement(int itemNo) {
        return driver.findElements(By.className("inventory_item")).get(itemNo);
    }
}
