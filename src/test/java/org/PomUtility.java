package org;

public class PomUtility {
    private static String driverLocation;

    public static void setDriver(String driverKey, String pathToDriver){
        System.setProperty(driverKey, pathToDriver);
    }


    public static String getDriverLocation() {
        return driverLocation;
    }

    public static void setDriverLocation(String driverLocation) {
        PomUtility.driverLocation = driverLocation;
    }
}