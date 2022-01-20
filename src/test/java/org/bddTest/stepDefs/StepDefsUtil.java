package org.bddTest.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.PomUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefsUtil {
    public static WebDriver driver;
    @Before
    public void setup() {
        PomUtility.setDriverLocation(PomUtility.getDefaultDriverLocation());
        PomUtility.setChromeDriverService(PomUtility.getDefaultDriverLocation());
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
