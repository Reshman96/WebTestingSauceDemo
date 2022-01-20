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

    private SlLoginPage loginPage;
    private SLInventoryPage inventoryPage;
    private WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.CHROME);
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

}