package org;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    WebDriver driver;

    @BeforeAll
    static void setupAll(){
        POMUtil.setDriverLocation(POMUtil.getDefaultDriverLocation());
        POMUtil.setChromeDriverService(POMUtil.getDefaultDriverLocation());

    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }
}
