package org;

import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class PomUtility {
    private static String driverLocation;

    public static void setDriver(String driverKey, String pathToDriver){
        System.setProperty(driverKey, pathToDriver);
    }

    public static ChromeDriverService setDriverService(String pathToDriver){
        return new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(pathToDriver))
                .usingAnyFreePort()
                .build();
    }

    public static String getDriverLocation() {
        return driverLocation;
    }

    public static void setDriverLocation(String driverLocation) {
        PomUtility.driverLocation = driverLocation;
    }
}