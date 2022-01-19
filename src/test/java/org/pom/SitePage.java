package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class SitePage extends Page{
    private WebDriver driver;

    By menuButton = new By.ById("");
    By basketButton = new By.ById("");
    By menuList = new By.ById("");
    By twitterLink = new By.ById("");
    By facebookLink = new By.ById("");
    By instaLink = new By.ById("");

    public SitePage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    public SlLoginPage logout() {
        return new SlLoginPage(driver);
    }

    public SLInventoryPage returnToShop() {
        return new SLInventoryPage(driver);
    }

}
