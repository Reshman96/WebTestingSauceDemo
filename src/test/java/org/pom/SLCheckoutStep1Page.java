package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SLCheckoutStep1Page extends SitePage {
    private String firstName;
    private String lastName;
    private String postalCode;
    private By checkout = By.id("checkout");
    private By cart = new By.ByClassName("shopping_cart_badge");
    private WebDriver driver;

    public SLCheckoutStep1Page(WebDriver driver) {
        super(new ChromeDriver());
        this.driver = driver;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Page goToCheckoutStep2Page() {
        driver.findElement(checkout).click();
        return new SLCheckoutStep2Page(driver);
    }

    public SLCartPage goToCart() {
        driver.findElement(cart).click();
        return new SLCartPage(driver);
    }

    public boolean isAnyFieldEmpty() {
        boolean result = true;
        if (getFirstName() == null) {
            System.out.println("first name is empty!");
            return false;
        }
        if (getLastName() == null) {
            System.out.println("last name is empty!");
            return false;
        }
        if (getPostalCode() == null) {
            System.out.println("zip/postal code is empty");
            return false;
        }
        return result;
    }
}
