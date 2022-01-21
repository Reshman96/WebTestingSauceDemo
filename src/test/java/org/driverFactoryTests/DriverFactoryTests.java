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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.remote.service.DriverService;

public class DriverFactoryTests {

    @BeforeAll
    static void setup(){
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.OPERA);

    }

    @Test
    @DisplayName("Check driver location")
    void checkDriverLocationTest() {
        switch (DriversFactory.getBrowser()){
            case CHROME -> Assertions.assertEquals("src/test/resources/chromedriver.exe", PomUtility.getDriverLocation());
            case FIREFOX -> Assertions.assertEquals("src/test/resources/geckodriver.exe", PomUtility.getDriverLocation());
            case IE -> Assertions.assertEquals("src/test/resources/IEDriverServer.exe", PomUtility.getDriverLocation());
            case EDGE -> Assertions.assertEquals("src/test/resources/msedgedriver.exe", PomUtility.getDriverLocation());
            case OPERA -> Assertions.assertEquals("src/test/resources/operadriver.exe", PomUtility.getDriverLocation());
        }


    }

    @Test
    @DisplayName("Check Web driver Object")
    void checkWebDriverObject() {
        WebDriver webDriverObject = DriversFactory.getWebDriver();
        switch (DriversFactory.getBrowser()){
            case CHROME -> Assertions.assertTrue(webDriverObject instanceof ChromeDriver);
            case FIREFOX -> Assertions.assertTrue(webDriverObject instanceof FirefoxDriver);
            case IE -> Assertions.assertTrue(webDriverObject instanceof InternetExplorerDriver);
            case EDGE -> Assertions.assertTrue(webDriverObject instanceof EdgeDriver);
            case OPERA -> Assertions.assertTrue(webDriverObject instanceof OperaDriver);
        }


    }

    @Test
    @DisplayName("Check Web driver service object")
    void checkWebDriverServiceObject() {
        DriverService driverService = DriversFactory.getDriverService(PomUtility.getDriverLocation());
        switch (DriversFactory.getBrowser()){
            case CHROME -> Assertions.assertTrue(driverService instanceof ChromeDriverService);
            case FIREFOX -> Assertions.assertTrue(driverService instanceof GeckoDriverService);
            case IE -> Assertions.assertTrue(driverService instanceof InternetExplorerDriverService);
            case EDGE -> Assertions.assertTrue(driverService instanceof EdgeDriverService);
            case OPERA -> Assertions.assertTrue(driverService instanceof OperaDriverService);
        }
    }
}