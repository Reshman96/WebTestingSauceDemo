package org.bddTest.stepDefs;

import org.openqa.selenium.WebDriver;
import org.pom.*;
import org.pom.inventoryPage.SLInventoryPage;

public class StepdefData {
    private static SLCheckoutStep1Page checkoutStep1Page;
    private static SLCheckoutStep2Page checkoutStep2Page;
    private static SLInventoryPage inventoryPage;
    private static SLIndividualItemPage individualItemPage;
    private static SLCartPage cartPage;
    private static SLConfirmationOfOrderPage confirmationPage;
    private static SlLoginPage loginPage;

    public static void setupClasses(WebDriver driver) {
        checkoutStep1Page = new SLCheckoutStep1Page(driver);
        inventoryPage = new SLInventoryPage(driver);
        individualItemPage = new SLIndividualItemPage(driver);
        cartPage = new SLCartPage(driver);
        confirmationPage = new SLConfirmationOfOrderPage(driver);
        loginPage = new SlLoginPage(driver);
        checkoutStep2Page = new SLCheckoutStep2Page(driver);
    }

    public static SLCheckoutStep2Page getCheckoutStep2Page() {
        return checkoutStep2Page;
    }

    public static SLCheckoutStep1Page getCheckoutStep1Page() {
        return checkoutStep1Page;
    }

    public static SLInventoryPage getInventoryPage() {
        return inventoryPage;
    }

    public static SLIndividualItemPage getIndividualItemPage() {
        return individualItemPage;
    }

    public static SLCartPage getCartPage() {
        return cartPage;
    }

    public static SLConfirmationOfOrderPage getConfirmationPage() {
        return confirmationPage;
    }

    public static SlLoginPage getLoginPage() {
        return loginPage;
    }
}
