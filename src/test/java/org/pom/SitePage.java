package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pom.inventoryPage.SLInventoryPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class SitePage extends Page{
    private WebDriver driver;

    public By menuButton = new By.ById("react-burger-menu-btn");
    public By basketButton = new By.ById("shopping_cart_container");
    public By menuList = new By.ByClassName("bm-menu");
    public By shoppingCartBadge = new By.ByClassName("shopping_cart_badge");
    public By twitterLink = new By.ByLinkText("Twitter"); //Classname = social_linkedin
    public By facebookLink = new By.ByLinkText("Facebook"); //Classname = social_facebook
    public By linkedInLink = new By.ByLinkText("LinkedIn"); //Classname = social_twitter

    public SitePage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    private void openBurgerMenu() {
        try{
            driver.findElement(By.id("menu_button_container")).findElement(By.cssSelector("[aria-hidden='true']"));
            driver.findElement(By.className("bm-burger-button")).click();
        } catch (NoSuchElementException ignored) {} //Ignored as that means its already open
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public SlLoginPage logout() {
        openBurgerMenu();
        driver.findElement(By.className("bm-item-list")).findElement(By.id("logout_sidebar_link")).click();
        return new SlLoginPage(driver);
    }

    public SLInventoryPage returnToShop() {
        openBurgerMenu();
        driver.findElement(By.className("bm-item-list")).findElement(By.id("inventory_sidebar_link")).click();
        return new SLInventoryPage(driver);
    }

    public String goToCompanyPage() {
        openBurgerMenu();
        driver.findElement(By.className("bm-item-list")).findElement(By.id("about_sidebar_link")).click();
        return driver.getCurrentUrl();
    }

    public void resetAppState() {
        openBurgerMenu();
        driver.findElement(By.className("bm-item-list")).findElement(By.id("reset_sidebar_link")).click();
    }
    public SLCartPage goToCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
        return new SLCartPage(driver);
    }

    public int getNumberOfCartItems(){
        int numberOfElements = 0;
        List<WebElement> itemsInCart = driver.findElements(shoppingCartBadge);
        for (WebElement ignored : itemsInCart){
            numberOfElements++;
        }
        return numberOfElements;
    }
}