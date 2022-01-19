package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SLCheckoutStep2Page extends SitePage {
    private WebDriver driver;
    private final By cancelButton = new By.ById("cancel");
    private final By finishButton = new By.ById("finish");

    public SLCheckoutStep2Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Page goToInventoryPage() {
        driver.findElement(cancelButton).click();
        return new SLInventoryPage(driver);
    }

    public Page goToConfirmationPage() {
        driver.findElement(finishButton).click();
        return new SLCheckoutStep2Page(driver);
    }
}
