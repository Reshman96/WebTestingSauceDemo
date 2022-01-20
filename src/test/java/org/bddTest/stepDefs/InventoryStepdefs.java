package org.bddTest.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.pom.SitePage;
import org.pom.inventoryPage.SLInventoryPage;

public class InventoryStepdefs {
    private WebDriver driver;
    private SLInventoryPage inventoryPage;
    private SitePage placeholderPage;
    @And("I am on the Inventory page")
    public void iAmOnTheInventoryPage() {
        driver = StepDefsUtil.driver;
        //should be able to assign inventory page as we should be logged in
        inventoryPage = new SLInventoryPage(driver);
        placeholderPage = new SitePage(driver) {}; //No way this is good practice.
    }

    @When("I click on add to cart for an item")
    public void iClickOnAddToCartForAnItem() {
        inventoryPage.addToCart(0);
    }

    @Then("the item is added to the basket")
    public void theItemIsAddedToTheBasket() {
        Assertions.assertEquals("Sauce Labs Backpack", inventoryPage.goToCart().getItemNameInCart(0));
    }

    @Then("the add to cart button is changed to remove")
    public void theAddToCartButtonIsChangedToRemove() {
        Assertions.assertEquals("REMOVE", inventoryPage.getInventoryElement(0).getText().substring(
                inventoryPage.getInventoryElement(0).getText().length()-6));
    }

    @When("I click to return to the inventory page")
    public void iClickToReturnToTheInventoryPage() {
        placeholderPage = placeholderPage.returnToShop();
    }

    @Then("I will be on the inventory page")
    public void iWillBeOnTheInventoryPage() {
        Assertions.assertInstanceOf(SLInventoryPage.class, placeholderPage);
    }
}