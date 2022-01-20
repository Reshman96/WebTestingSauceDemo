package org.bddTest.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefsUtil {
    public static WebDriver driver;
    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
