package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.pom.inventoryPage.SLInventoryPage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class SitePage extends Page{
    private final WebDriver driver;

    public By menuButton = new By.ByClassName("bm-burger-button");
    public By hidden = new By.ByCssSelector("[aria-hidden='true']");
    public By basketButton = new By.ById("shopping_cart_container");
    public By menuList = new By.ById("menu_button_container");
    public By itemList = new By.ByClassName("bm-item-list");
    public By logout = new By.ById("logout_sidebar_link");
    public By inventory = new By.ById("inventory_sidebar_link");
    public By about = new By.ById("about_sidebar_link");
    public By reset = new By.ById("reset_sidebar_link");
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
            driver.findElement(menuList).findElement(hidden);
            driver.findElement(menuButton).click();
        } catch (NoSuchElementException ignored) {} //Ignored as that means its already open
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public SlLoginPage logout() {
        openBurgerMenu();
        driver.findElement(itemList).findElement(logout).click();
        return new SlLoginPage(driver);
    }

    public SLInventoryPage returnToShop() {
        openBurgerMenu();
        driver.findElement(itemList).findElement(inventory).click();
        return new SLInventoryPage(driver);
    }

    public String goToCompanyPage() {
        openBurgerMenu();
        driver.findElement(itemList).findElement(about).click();
        return driver.getCurrentUrl();
    }

    public String goToTwitterPage() {
        driver.findElement(twitterLink).click();
        changeTab();
        return driver.getCurrentUrl();
    }

    public String goToFacebookPage() {
        driver.findElement(facebookLink).click();
        changeTab();
        return driver.getCurrentUrl();
    }

    public String goToLinkedInPage() {
        driver.findElement(linkedInLink).click();
        changeTab();
        return driver.getCurrentUrl();
    }

    private void changeTab() {
        String originalTab = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        for(String tab : handles) {
            if (!originalTab.equals(tab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    public void resetAppState() {
        openBurgerMenu();
        driver.findElement(itemList).findElement(reset).click();
    }

    public SLCartPage goToCart() {
        driver.findElement(basketButton).click();
        return new SLCartPage(driver);
    }

//    public int getNumberOfCartItems(){
////        int numberOfElements = 0;
////        List<WebElement> itemsInCart = driver.findElements(shoppingCartBadge);
////        for (WebElement ignored : itemsInCart){
////            numberOfElements++;
////        }
////        return numberOfElements;
////    }

    public int getNumberOfCartItems(){
        try {
            return Integer.parseInt(driver.findElement(shoppingCartBadge).getText());
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

}