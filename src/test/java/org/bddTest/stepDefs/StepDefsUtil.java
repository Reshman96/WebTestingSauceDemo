package org.bddTest.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.DriversFactory;
import org.PomUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;

import java.io.IOException;

public class StepDefsUtil {
    public static WebDriver driver;
    public static DriverService driverService;


    @Before(order = 1)
    public void setup() {
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.CHROME);
        driver = DriversFactory.getWebDriver();
        StepdefData.setupClasses(driver);
        driverService = DriversFactory.getDriverService(PomUtility.getDriverLocation());
        try {
            driverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void teardown() {
        driver.quit();
        driverService.stop();
    }
}
