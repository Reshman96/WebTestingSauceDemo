package org.bddTest.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.DriversFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.pom.SlLoginPage;
import org.pom.inventoryPage.SLInventoryPage;

public class LoginStepdefs {

    @When("I enter a valid username and password")
    public void iEnterValidUsernameAndPassword() {
        StepdefData.getLoginPage().Login("standard_user", "secret_sauce");
    }

    @Then("I will be logged in")
    public void iWillBeLoggedIn() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", StepdefData.getInventoryPage().getURL());
    }

    @When("I provide an incorrect username and password")
    public void iProvideIncorrectUsernameAndPassword() {
        StepdefData.getLoginPage().Login("incorrect", "incorrect");
    }

    @Then("I will not be logged in")
    public void iWillNotBeLoggedIn() {
        Assertions.assertEquals("https://www.saucedemo.com/", StepdefData.getLoginPage().getURL());
    }

    @When("I enter a valid username and password but the account is locked out")
    public void iEnterValidUsernameAndPasswordButTheAccountIsLockedOut() {
        StepdefData.getLoginPage().Login("locked_out_user", "secret_sauce");
    }

    @When("I leave the username or password box blank")
    public void iLeaveTheUsernameOrPasswordBoxBlank() {
        StepdefData.getLoginPage().Login("", "");
    }

    @When("I enter a valid username and password but the account is a problem user")
    public void iEnterValidUsernameAndPasswordButTheAccountIsAProblemUser() {
        StepdefData.getLoginPage().Login("problem_user", "secret_sauce");
    }

    @When("I enter a valid username and password but the account is a performance glitch user")
    public void iEnterValidUsernameAndPasswordButTheAccountIsAPerformanceGlitchUser() {
        StepdefData.getLoginPage().Login("performance_glitch_user", "secret_sauce");
    }

    @Then("the product images will be wrong")
    public void theProductImagesWillBeWrong() {
        Assertions.assertEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", StepdefData.getInventoryPage().getInventoryElementImageLink(1));
    }

    @Then("the product images will be correct")
    public void theProductImagesWillBeCorrect() {
        Assertions.assertEquals("https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", StepdefData.getInventoryPage().getInventoryElementImageLink(0));
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        //blank because we should already be there from setup
    }
}