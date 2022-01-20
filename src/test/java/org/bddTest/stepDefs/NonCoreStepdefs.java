package org.bddTest.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pom.SLCartPage;
import org.pom.SLCheckoutStep1Page;
import org.pom.SLIndividualItemPage;
import org.pom.SlLoginPage;
import org.pom.inventoryPage.SLInventoryPage;

public class NonCoreStepdefs {
    private WebDriver driver;
    private SlLoginPage loginPage;
    private SLInventoryPage inventoryPage;
    private SLCheckoutStep1Page checkoutStep1Page;
    private SLCartPage cartPage;
    private SLIndividualItemPage slIndividualItemPage;
    private String productName;

    @Before(order = 3)
    public void setup() {
        driver = StepDefsUtil.driver;
        loginPage = new SlLoginPage(driver);
    }

    @Then("The website should give me an error saying {string}")
    public void theWebsiteShouldGiveMeAnErrorSaying(String string) {
        String errorMessage = driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText().toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < errorMessage.length(); i++) {
            if (i >= 7) {
                sb.append(errorMessage.toCharArray()[i]);
            }
        }
        Assertions.assertEquals(string, sb.toString());
    }

    @When("The first name field is empty")
    public void theFirstNameFieldIsEmpty() {
        new SLCheckoutStep1Page(driver).setFirstName("");
    }

    @When("The last name field is empty")
    public void theLastNameFieldIsEmpty() {
        checkoutStep1Page.setLastName("");
    }

    @When("The postal code field is empty")
    public void thePostalCodeFieldIsEmpty() {
        checkoutStep1Page.setPostalCode("");
    }

    @And("The first name field is filled")
    public void theFirstNameFieldIsFilled() {
        checkoutStep1Page.setFirstName("Luciano");
    }

    @And("The last name field is filled")
    public void theLastNameFieldIsFilled() {
        checkoutStep1Page.setLastName("Big Tuna");
    }

    @And("The postal code field is filled")
    public void thePostalCodeFieldIsFilled() {
        checkoutStep1Page.setPostalCode("0123");
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
