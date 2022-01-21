package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

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
                options.setHeadless(true);
                return new ChromeDriver(options);
            case FIREFOX:
                return new FirefoxDriver();
            case IE:
                return new InternetExplorerDriver();
            case EDGE:
                return new EdgeDriver();
            case OPERA:
                return new OperaDriver();
        }
        throw new IllegalArgumentException();
    }

    public enum BrowsersEnums {
        CHROME, FIREFOX, IE, EDGE, OPERA
    }

}