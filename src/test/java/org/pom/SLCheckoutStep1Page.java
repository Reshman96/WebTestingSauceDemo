package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SLCheckoutStep1Page extends SitePage {
    // Temporary default values for firstName, lastName and postalCode
    private String firstName;
    private String lastName;
    private String postalCode;
    private final By continueButton = By.id("continue");
    private final By cancelButton = new By.ById("cancel");
    private WebDriver driver;

    public SLCheckoutStep1Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        driver.findElement(By.id("last-name")).sendKeys(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    private void setPostalCode(String postalCode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        this.postalCode = postalCode;
    }

    public SLCheckoutStep2Page goToCheckoutStep2Page() {
        setFirstName("James");
        setLastName("Bond");
        setPostalCode("007");
        driver.findElement(continueButton).click();
        return new SLCheckoutStep2Page(driver);
    }

    public SLCartPage goToCart() {
        driver.findElement(cancelButton).click();
        return new SLCartPage(driver);
    }
}
