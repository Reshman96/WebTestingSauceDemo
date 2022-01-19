package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SLConfirmationOfOrderPage extends SitePage {

    private final By backToProduct = new By.ById("back-to-products");
    private final WebDriver driver;

    public SLConfirmationOfOrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SLInventoryPage returnToInventoryPage() {
        driver.findElement(backToProduct).click();
        return new SLInventoryPage(driver);
    }


}
