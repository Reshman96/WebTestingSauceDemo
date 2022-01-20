package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriversFactory {
    private static BrowsersEnums browser;

    public static void driverLoader(BrowsersEnums driver) {

        switch (driver) {
            case CHROME: {
                PomUtility.setDriverLocation("src/test/resources/chromedriver.exe");
                PomUtility.setDriver("webdriver.chrome.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.CHROME;
                break;
            }

            case FIREFOX: {
                PomUtility.setDriverLocation("src/test/resources/geckodriver.exe");
                PomUtility.setDriver("webdriver.gecko.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.FIREFOX;
                break;
            }

            case IE: {
                PomUtility.setDriverLocation("src/test/resources/IEDriverServer.exe");
                PomUtility.setDriver("webdriver.ie.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.IE;
                break;
            }

            case EDGE: {
                PomUtility.setDriverLocation("src/test/resources/msedgedriver.exe");
                PomUtility.setDriver("webdriver.edge.driver", PomUtility.getDriverLocation());
                browser = BrowsersEnums.EDGE;
                break;
            }

            case OPERA: {
                PomUtility.setDriverLocation("src/test/resources/operadriver.exe");
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

            case FIREFOX:
                return new FirefoxDriver();

            case IE:
                return new InternetExplorerDriver();

            case EDGE:
                return new EdgeDriver();

            case OPERA:
                return new OperaDriver();

        }
        return null;
    }

    public enum BrowsersEnums {
        CHROME, FIREFOX, IE, EDGE, OPERA
    }

}
