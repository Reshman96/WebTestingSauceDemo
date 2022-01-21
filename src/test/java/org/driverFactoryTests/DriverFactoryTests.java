package org.driverFactoryTests;

import org.DriversFactory;
import org.PomUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.service.DriverService;

public class DriverFactoryTests {

    @BeforeAll
    static void setup(){
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.CHROME);

    }

    @Test
    @DisplayName("Check driver location")
    void checkDriverLocationTest() {
        Assertions.assertEquals("src/test/resources/chromedriver.exe", PomUtility.getDriverLocation());

    }

    @Test
    @DisplayName("Check Web driver Object")
    void checkWebDriverObject() {
        WebDriver webDriverObject = DriversFactory.getWebDriver();
        Assertions.assertTrue(webDriverObject instanceof ChromeDriver);

    }

    @Test
    @DisplayName("Check Web driver service object")
    void checkWebDriverServiceObject() {
        DriverService driverService = DriversFactory.getDriverService(PomUtility.getDriverLocation());
        Assertions.assertTrue(driverService instanceof ChromeDriverService);

    }
}
