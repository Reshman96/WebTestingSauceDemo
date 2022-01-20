package org.bddTest.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.DriversFactory;
import org.PomUtility;
import org.openqa.selenium.WebDriver;
import org.pom.SLConfirmationOfOrderPage;
import org.pom.SlLoginPage;
import org.pom.inventoryPage.SLInventoryPage;

public class ConfirmationStepdefs {
    private WebDriver driver;
    private SlLoginPage loginPage;
    private SLInventoryPage inventoryPage;
    private SLConfirmationOfOrderPage confirmationPage;

    @And("I am on the confirmation page")
    public void iAmOnTheConfirmationPage() {
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.CHROME);
        driver = StepDefsUtil.driver;
        loginPage = new SlLoginPage(driver);
        inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        confirmationPage = inventoryPage.goToCart()
                .goToCheckoutStep1Page()
                .goToCheckoutStep2Page()
                .goToConfirmationPage();


    }

    @When("I click on back home")
    public void iClickOnBackHome() {
        inventoryPage = confirmationPage.returnToInventoryPage();
    }
}
