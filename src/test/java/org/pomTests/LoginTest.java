package org.pomTests;

import org.PomUtility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.inventoryPage.SLInventoryPage;
import org.pom.SlLoginPage;

public class LoginTest {

    private static WebDriver driver;
    private static SlLoginPage loginPage;

    @BeforeAll
    static void setupAll() {
        PomUtility.setDriverLocation(PomUtility.getDefaultDriverLocation());
        PomUtility.setChromeDriverService(PomUtility.getDefaultDriverLocation());
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new SlLoginPage(driver);
    }

    @Test
    @DisplayName("check login works")
    void checkLoginWorks() {
        SLInventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getURL());
    }
    @Test
    void checkStandardUserLogin() {
        SLInventoryPage inventoryPage = loginPage.StandardUserLogin();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getURL());
    }
    @Test
    void checkLockedOutUserLogin() {
        SLInventoryPage inventoryPage = loginPage.LockedOutUserLogin();
        Assertions.assertEquals("https://www.saucedemo.com/", inventoryPage.getURL());
    }
    @Test
    void checkProblemUserLogin() {
        SLInventoryPage inventoryPage = loginPage.ProblemUserLogin();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getURL());
    }
    @Test
    void checkPerformanceGlitchUserLogin() {
        SLInventoryPage inventoryPage = loginPage.PerformanceGlitchUserLogin();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getURL());
    }

    @AfterAll
    static void teardownAll() {
        driver.quit();
    }
}
