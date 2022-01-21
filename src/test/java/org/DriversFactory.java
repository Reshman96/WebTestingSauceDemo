package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;

public class DriversFactory {
    private static BrowsersEnums browser;

    public static void driverLoader(BrowsersEnums driver) {

        switch (driver) {
            case CHROME -> {
                PomUtility.setDriverLocation("src/test/resources/chromedriver.exe");
                PomUtility.setDriver("webdriver.chrome.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.CHROME;
            }
            case FIREFOX -> {
                PomUtility.setDriverLocation("src/test/resources/geckodriver.exe");
                PomUtility.setDriver("webdriver.gecko.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.FIREFOX;
            }
            case IE -> {
                PomUtility.setDriverLocation("src/test/resources/IEDriverServer.exe");
                PomUtility.setDriver("webdriver.ie.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.IE;
            }
            case EDGE -> {
                PomUtility.setDriverLocation("src/test/resources/msedgedriver.exe");
                PomUtility.setDriver("webdriver.edge.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.EDGE;
            }
            case OPERA -> {
                PomUtility.setDriverLocation("src/test/resources/operadriver.exe");
                PomUtility.setDriver("webdriver.opera.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.OPERA;
            }
        }
    }

    public static WebDriver getWebDriver() {
        switch (browser) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                //options.setHeadless(true);
                return new ChromeDriver(options);

            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            case IE:
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                return new InternetExplorerDriver(internetExplorerOptions);
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                return new EdgeDriver(edgeOptions);
            case OPERA:
                OperaOptions operaOptions = new OperaOptions();
                return new OperaDriver(operaOptions);
        }
        throw new IllegalArgumentException();
    }



    public static DriverService getDriverService(String pathToDriver) {
        switch (browser) {
            case CHROME:
                return new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(pathToDriver))
                        .usingAnyFreePort()
                        .build();

            case FIREFOX:
                return new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File(pathToDriver))
                        .usingAnyFreePort()
                        .build();

            case IE:
                return new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(new File(pathToDriver))
                        .usingAnyFreePort()
                        .build();

            case EDGE:
                return new EdgeDriverService.Builder()
                        .usingDriverExecutable(new File(pathToDriver))
                        .usingAnyFreePort()
                        .build();

            case OPERA:
                return new OperaDriverService.Builder()
                        .usingDriverExecutable(new File(pathToDriver))
                        .usingAnyFreePort()
                        .build();

        }
        throw new IllegalArgumentException();
    }

    public static BrowsersEnums getBrowser() {
        return browser;
    }

    public enum BrowsersEnums {
        CHROME, FIREFOX, IE, EDGE, OPERA
    }
}