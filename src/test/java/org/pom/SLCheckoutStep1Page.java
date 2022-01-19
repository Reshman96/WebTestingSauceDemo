package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SLCheckoutStep1Page extends Page {
    private String firstName;
    private String lastName;
    private String postalCode;
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
        // temporarily returning new SLCheckoutStep1Page
        return new SLCheckoutStep1Page(new ChromeDriver());
    }

    public SLCartPage goToCart() {
        // temporarily returning new SLCartPage
        return new SLCartPage();
    }

    public boolean isAnyFieldEmpty() {
        // temporarily set to return true
        return true;
    }
}
