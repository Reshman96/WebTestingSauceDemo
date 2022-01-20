package org.bddTest.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.DriversFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.rmi.UnexpectedException;

public class StepDefsUtil {
    public static WebDriver driver;

    @Before(order = 1)
    public void setup() {
        System.out.println("Setup called!");
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.CHROME);
        System.out.println("Setup called!");

        driver = DriversFactory.getWebDriver();

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
