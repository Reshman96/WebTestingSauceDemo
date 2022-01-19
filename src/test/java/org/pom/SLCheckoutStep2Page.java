package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SLCheckoutStep2Page extends Page {
    private WebDriver driver;

    public SLCheckoutStep2Page(WebDriver driver) {
        super(new ChromeDriver());
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Page goToConfirmationPage() {
        return new SLCheckoutStep2Page(new ChromeDriver());
    }
}
