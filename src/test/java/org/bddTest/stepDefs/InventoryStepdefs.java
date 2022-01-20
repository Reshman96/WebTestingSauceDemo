package org.bddTest.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class InventoryStepdefs {
    private WebDriver driver;
    @And("I am on the Inventory page")
    public void iAmOnTheInventoryPage() {
        driver = StepDefsUtil.driver;
    }

    @When("I click on add to cart for an item")
    public void iClickOnAddToCartForAnItem() {
    }

    @Then("the item is added to the basket")
    public void theItemIsAddedToTheBasket() {
    }

    @When("I click on add to cart button for any item")
    public void iClickOnAddToCartButtonForAnyItem() {
    }

    @Then("the add to cart button is changed to remove")
    public void theAddToCartButtonIsChangedToRemove() {
    }

}