package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class SitePage extends Page{
    private WebDriver driver;

    By menuButton = new By.ById("react-burger-menu-btn");
    By basketButton = new By.ById("shopping_cart_container");
    By menuList = new By.ByClassName("bm-menu");
    By twitterLink = new By.ByLinkText("Twitter"); //Classname = social_linkedin
    By facebookLink = new By.ByLinkText("Facebook"); //Classname = social_facebook
    By linkedInLink = new By.ByLinkText("LinkedIn"); //Classname = social_twitter

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
