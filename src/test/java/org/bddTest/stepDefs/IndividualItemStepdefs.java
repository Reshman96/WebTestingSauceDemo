package org.bddTest.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pom.SLIndividualItemPage;
import org.pom.inventoryPage.SLInventoryPage;

public class IndividualItemStepdefs {
    private WebDriver driver;
    private SLInventoryPage slInventoryPage;
    private SLIndividualItemPage slIndividualItemPage;

    @And("I am on the individual item page")
    public void iAmOnTheIndividualItemPage() {

    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
    }

    @Then("The item is added to the basket")
    public void theItemIsAddedToTheBasket() {
    }

    @And("I click on remove button")
    public void iClickOnRemoveButton() {
    }

    @Then("The item is removed from the basket")
    public void theItemIsRemovedFromTheBasket() {
    }
}
