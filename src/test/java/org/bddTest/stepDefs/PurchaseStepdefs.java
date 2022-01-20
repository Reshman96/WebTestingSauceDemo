package org.bddTest.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.pom.SLCartPage;
import org.pom.SLCheckoutStep1Page;
import org.pom.SLCheckoutStep2Page;
import org.pom.inventoryPage.SLInventoryPage;

public class PurchaseStepdefs {

    private SLInventoryPage inventoryPage;
    private SLCartPage cartPage;
    private SLCheckoutStep1Page checkoutStep1Page;
    private SLCheckoutStep2Page checkoutStep2Page;

    @And("I am on the cart page")
    public void iAmOnTheCartPage() {
        inventoryPage = LogOutStepdefs.inventoryPage;
        cartPage = inventoryPage.goToCart();
    }

    @When("I click on checkout")
    public void iClickOnCheckout() {
        checkoutStep1Page = cartPage.goToCheckoutStep1Page();
    }

    @Then("I am prompted to put in details")
    public void iAmPromptedToPutInDetails() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", checkoutStep1Page.getURL());
    }

    @And("I am going through with a purchase")
    public void iAmGoingThroughWithAPurchase() {
        checkoutStep1Page = cartPage.goToCheckoutStep1Page();
    }

    @When("I confirm my purchase")
    public void iConfirmMyPurchase() {
        checkoutStep2Page = checkoutStep1Page.goToCheckoutStep2Page();
    }

    @Then("The website should thank me for my order, and say it is on it’s way.")
    public void theWebsiteShouldThankMeForMyOrderAndSayItIsOnItSWay() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutStep2Page.getURL());
    }

}