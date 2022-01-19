package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SLCartPage extends SitePage{

    private final By cartItem = By.className("cart_item");
    private final By removeButton = By.className("cart_button");
    private final By continueShopping = By.id("continue-shopping");
    private final By checkout = By.id("checkout");
    private final WebDriver driver;

    public SLCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SLCheckoutStep1Page goToCheckoutStep1Page() {
        driver.findElement(checkout).click();
        return new SLCheckoutStep1Page(driver);
    }

    public SLInventoryPage goToProductPage() {
        driver.findElement(continueShopping).click();
        return new SLInventoryPage(driver);
    }

    public SLIndividualItemPage goToIndividualItemPage() {
        driver.findElement(cartItem).click();
        return new SLIndividualItemPage(driver);
    }

    public SLCartPage removeItem() {
        driver.findElement(removeButton).click();
        return new SLCartPage(driver);
    }

}