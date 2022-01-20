package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pom.inventoryPage.SLInventoryPage;

public abstract class SitePage extends Page{
    private WebDriver driver;

    public By menuButton = new By.ById("react-burger-menu-btn");
    public By basketButton = new By.ById("shopping_cart_container");
    public By menuList = new By.ByClassName("bm-menu");
    public By twitterLink = new By.ByLinkText("Twitter"); //Classname = social_linkedin
    public By facebookLink = new By.ByLinkText("Facebook"); //Classname = social_facebook
    public By linkedInLink = new By.ByLinkText("LinkedIn"); //Classname = social_twitter

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