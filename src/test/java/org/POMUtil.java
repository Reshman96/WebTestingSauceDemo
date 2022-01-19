package org;

import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class POMUtil {
    private static String defaultDriverLocation = "src/test/resources/chromedriver.exe";

    public static void setDriverLocation(String pathToDriver){
        System.setProperty("webdriver.chrome.driver", pathToDriver);
    }

    public static ChromeDriverService setChromeDriverService(String pathToDriver){
        return new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(pathToDriver))
                .usingAnyFreePort()
                .build();
    }

    public static String getDefaultDriverLocation() {
        return defaultDriverLocation;
    }
}
