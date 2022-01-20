package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriversFactory {
    private static BrowsersEnums browser;

    public static void driverLoader(BrowsersEnums driver) {

        switch (driver) {
            case CHROME: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation() + "/chromedriver.exe");
                PomUtility.setDriver("webdriver.chrome.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.CHROME;
                break;
            }

            case FIREFOX: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation() + "/geckodriver.exe");
                PomUtility.setDriver("webdriver.gecko.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.FIREFOX;
                break;
            }

            case IE: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation() + "/IEDriverServer.exe");
                PomUtility.setDriver("webdriver.ie.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.IE;
                break;
            }

            case EDGE: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation() + "/msedgedriver.exe");
                PomUtility.setDriver("webdriver.edge.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.EDGE;
                break;
            }

            case OPERA: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation() + "/operadriver.exe");
                PomUtility.setDriver("webdriver.opera.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.OPERA;
                break;
            }

        }
    }
    public static WebDriver getWebDriver() {
        switch (browser) {
            case CHROME:
                return new ChromeDriver();
        }
        switch (browser) {
            case FIREFOX:
                return new ChromeDriver();
        }
        switch (browser) {
            case IE:
                return new ChromeDriver();
        }
        switch (browser) {
            case EDGE:
                return new ChromeDriver();
        }
        switch (browser) {
            case OPERA:
                return new ChromeDriver();
        }
        return null;
    }

    public enum BrowsersEnums {
        CHROME, FIREFOX, IE, EDGE, OPERA
    }
}

