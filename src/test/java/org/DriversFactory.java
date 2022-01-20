package org;

public class DriversFactory {

    public static void driverLoader(BrowsersEnums driver){
        switch (driver){
            case CHROME: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation()+"/chromedriver.exe");
                PomUtility.setDriver("webdriver.chrome.driver", PomUtility.getDriverLocation());
                PomUtility.setDriverService(PomUtility.getDriverLocation());
            }

            case FIREFOX: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation()+"/geckodriver.exe");
                PomUtility.setDriver("webdriver.gecko.driver", PomUtility.getDriverLocation());
            }

            case IE: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation()+"/IEDriverServer.exe");
                PomUtility.setDriver("webdriver.ie.driver", PomUtility.getDriverLocation());
            }

            case EDGE: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation()+"/msedgedriver.exe");
                PomUtility.setDriver("webdriver.edge.driver", PomUtility.getDriverLocation());
            }

            case OPERA: {
                PomUtility.setDriverLocation(PomUtility.getDriverLocation()+"/operadriver.exe");
                PomUtility.setDriver("webdriver.opera.driver", PomUtility.getDriverLocation());

            }

        }
    }

    public enum BrowsersEnums {
        CHROME, FIREFOX, IE, EDGE, OPERA
    }
}

