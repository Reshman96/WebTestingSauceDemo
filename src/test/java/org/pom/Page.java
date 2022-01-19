package org.pom;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    private WebDriver driver;
    public Page(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
}
