package org.bddTest.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.PomUtility;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.pom.SlLoginPage;
import org.pom.inventoryPage.SLInventoryPage;

public class LoginStepdefs {

    private SlLoginPage loginPage;
    private SLInventoryPage inventoryPage;
    private WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        PomUtility.setDriverLocation(PomUtility.getDefaultDriverLocation());
        PomUtility.setChromeDriverService(PomUtility.getDefaultDriverLocation());
        driver = StepDefsUtil.driver;
        loginPage = new SlLoginPage(driver);
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        inventoryPage = loginPage.Login("standard_user", "secret_sauce");
    }

    @Then("I will be logged in")
    public void iWillBeLoggedIn() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getURL());
    }

    @When("I provide incorrect username and password")
    public void iProvideIncorrectUsernameAndPassword() {
        inventoryPage = loginPage.Login("incorrect", "incorrect");
    }

    @Then("I will not be logged in")
    public void iWillNotBeLoggedIn() {
        Assertions.assertEquals("https://www.saucedemo.com/", inventoryPage.getURL());
    }

    @When("I enter valid username and password but the account is locked out")
    public void iEnterValidUsernameAndPasswordButTheAccountIsLockedOut() {
        inventoryPage = loginPage.Login("locked_out_user", "secret_sauce");
    }

    @When("I leave the username or password box blank")
    public void iLeaveTheUsernameOrPasswordBoxBlank() {
        inventoryPage = loginPage.Login("", "");
    }

    @When("I enter valid username and password but the account is a problem user")
    public void iEnterValidUsernameAndPasswordButTheAccountIsAProblemUser() {
        inventoryPage = loginPage.Login("problem_user", "secret_sauce");
    }

    @When("I enter valid username and password but the account is a performance glitch user")
    public void iEnterValidUsernameAndPasswordButTheAccountIsAPerformanceGlitchUser() {
        inventoryPage = loginPage.Login("performance_glitch_user", "secret_sauce");
    }

    @Then("the product images will be wrong")
    public void theProductImagesWillBeWrong() {
        Assertions.assertEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", inventoryPage.getInventoryElementImageLink(1));
    }

    @Then("the product images will be correct")
    public void theProductImagesWillBeCorrect() {
        Assertions.assertEquals("https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", inventoryPage.getInventoryElementImageLink(0));
    }
}