package org.bddTest.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.pom.SlLoginPage;
import org.pom.inventoryPage.SLInventoryPage;

public class LogOutStepdefs {

    private SlLoginPage loginPage;
    public static SLInventoryPage inventoryPage;
    private WebDriver driver;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        driver = StepDefsUtil.driver;
        loginPage = new SlLoginPage(driver);
        inventoryPage = loginPage.Login("standard_user", "secret_sauce");
    }

    @When("I click on logout button")
    public void iClickOnLogoutButton() {
        loginPage = inventoryPage.logout();
    }

    @Then("I will be logged out")
    public void iWillBeLoggedOut() {
        Assertions.assertEquals("https://www.saucedemo.com/", loginPage.getURL());
    }

}