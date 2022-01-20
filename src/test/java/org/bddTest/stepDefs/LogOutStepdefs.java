package org.bddTest.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LogOutStepdefs {
    private WebDriver driver;
    @Given("I am logged in")
    public void iAmLoggedIn() {
        driver = StepDefsUtil.driver;
    }

    @When("I click on logout button")
    public void iClickOnLogoutButton() {
    }

    @Then("I will be logged out")
    public void iWillBeLoggedOut() {
    }

}