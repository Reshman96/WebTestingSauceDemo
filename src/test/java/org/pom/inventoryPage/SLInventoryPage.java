package org.pom.inventoryPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pom.SLCartPage;
import org.pom.SLIndividualItemPage;
import org.pom.SitePage;

public class SLInventoryPage extends SitePage {
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

    public SLInventoryPage removeFromCart(int itemNo) {
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

    public SLInventoryPage openFilterAccordian() {
        driver.findElement(By.className("product_sort_container")).click();
        return this;
    }

    public SLInventoryPage chooseFilterOption(String option) {
        driver.findElement(By.cssSelector("option[value='" + option + "']")).click();
        return this;
    }

    public String getInventoryElementImageLink(int itemNo) {
        return getInventoryElement(itemNo).findElement(By.className("inventory_item_img")).findElement(By.className("inventory_item_img")).getAttribute("src");
    }

    public String getInventoryElementName(int itemNo) {
        return getInventoryElement(itemNo).findElement(By.className("inventory_item_name")).getText();
    }
}
