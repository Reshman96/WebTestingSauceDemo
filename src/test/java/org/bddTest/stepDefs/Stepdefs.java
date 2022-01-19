package org.bddTest.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

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

    @Given("I am logged in")
    public void iAmLoggedIn() {
    }

    @And("I am on the cart page")
    public void iAmOnTheCartPage() {
    }

    @When("I click on checkout")
    public void iClickOnCheckout() {
    }

    @Then("I am prompted to put in details")
    public void iAmPromptedToPutInDetails() {
    }

    @And("I am going through with a purchase")
    public void iAmGoingThroughWithAPurchase() {
    }

    @When("I confirm my purchase")
    public void iConfirmMyPurchase() {
    }

    @Then("The website should thank me for my order, and say it is on it’s way.")
    public void theWebsiteShouldThankMeForMyOrderAndSayItIsOnItSWay() {
    }

    @And("I am on the Inventory page")
    public void iAmOnTheInventoryPage() {
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

    @When("I click on logout button")
    public void iClickOnLogoutButton() {
    }

    @Then("I will be logged out")
    public void iWillBeLoggedOut() {
    }

}