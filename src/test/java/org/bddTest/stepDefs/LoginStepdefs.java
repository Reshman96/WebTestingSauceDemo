package org.bddTest.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefs {

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
    }

    @Then("I will be logged in")
    public void iWillBeLoggedIn() {
    }

    @When("I provide incorrect username and password")
    public void iProvideIncorrectUsernameAndPassword() {
    }

    @Then("I will not be logged in")
    public void iWillNotBeLoggedIn() {
    }

    @When("I enter valid username and password but the account is locked out")
    public void iEnterValidUsernameAndPasswordButTheAccountIsLockedOut() {
    }

    @When("I leave the username or password box blank")
    public void iLeaveTheUsernameOrPasswordBoxBlank() {
    }

}