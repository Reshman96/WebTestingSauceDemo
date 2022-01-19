package org.pom;

import org.openqa.selenium.WebDriver;

public class SLInventoryPage extends SitePage{
    private WebDriver driver;

    public SLInventoryPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    public SLIndividualItemPage goToItem(int itemNo) {
        return new SLIndividualItemPage(driver);
    }

    public SLCartPage goToCart() {
        return new SLCartPage(driver);
    }

    SLInventoryPage addToCart(int itemNo) {
        return this;
    }
}
