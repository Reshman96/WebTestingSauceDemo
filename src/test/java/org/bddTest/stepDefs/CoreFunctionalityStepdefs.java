package org.bddTest.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.pom.*;
import org.pom.inventoryPage.SLInventoryPage;

public class CoreFunctionalityStepdefs {

    private SLCheckoutStep1Page checkoutStep1Page;
    private SLInventoryPage inventoryPage;
    private SLIndividualItemPage individualItemPage;
    private SitePage sitePage;
    private SLCartPage cartPage;
    private SLConfirmationOfOrderPage confirmationPage;
    private SlLoginPage loginPage;
    private WebDriver driver;

    @Before(order = 2)
    public void setup() {
        //StepDefsUtil.setup();
        driver = StepDefsUtil.driver;

    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        StepdefData.getLoginPage().StandardUserLogin();
    }

    //CheckoutStep1Stepdefs
    @And("I am on checkoutStep1 page")
    public void iAmOnCheckoutStepPage1() {
         StepdefData.getCartPage().goToCheckoutStep1Page();
    }

    @And("I click on continue")
    public void iClickOnContinue() {
        StepdefData.getCheckoutStep1Page().clickContinueButton();
    }

    //ConfirmationStepdefs

    @And("I am on the confirmation page")
    public void iAmOnTheConfirmationPage() {
        //sitePage = loginPage.Login("standard_user", "secret_sauce");
        //sitePage = inventoryPage.goToCart()
        //        .goToCheckoutStep1Page()
        //        .goToCheckoutStep2Page()
        //        .goToConfirmationPage();
        StepdefData.getCheckoutStep2Page().goToConfirmationPage();
    }

    @When("I click on back home")
    public void iClickOnBackHome() {
        StepdefData.getConfirmationPage().returnToInventoryPage();
    }

    //EveryPage
    @Given("Im on the inventory page")
    public void imOnTheInventoryPage() {
        try {
            StepdefData.getLoginPage().StandardUserLogin();
        } catch(NoSuchElementException e) {
            Assumptions.assumeTrue(StepdefData.getInventoryPage().getURL().equals("https://www.saucedemo.com/inventory.html")); //Default use of InventoryPage
        }
    }

    //@Given("Im on the product page")
    //public void imOnTheProductPage() {
    //    sitePage = new SlLoginPage(driver).StandardUserLogin().goToItem(1);
    //}

    @Given("Im on the checkout step 1 page")
    public void imOnTheCheckoutStep1Page() {
        StepdefData.getCartPage().goToCheckoutStep1Page();
    }

    @Given("Im on the checkout step 2 page")
    public void imOnTheCheckoutStep2Page() {
        StepdefData.getCheckoutStep1Page()
                .goToCheckoutStep2Page();
    }

    @When("I click the basket")
    public void iClickTheBasket() {
        StepdefData.getInventoryPage().goToCart(); //Default use of InventoryPage
    }

    //Individual
    @And("I am on the individual item page")
    public void iAmOnTheIndividualItemPage() {
        StepdefData.getInventoryPage().goToItem(0);
        //String productName = individualItemPage.getProductName();
    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        StepdefData.getIndividualItemPage().addItemToCart();
    }

    @Then("Cart icon shows one item")
    public void cartIconShowsOneItem() {
        Assertions.assertEquals(1, StepdefData.getIndividualItemPage().getNumberOfCartItems());
    }

    @Then("My item is in the cart")
    public void myItemIsInTheCart() {
        StepdefData.getInventoryPage().goToCart(); //Default use of InventoryPage
        String productName = StepdefData.getCartPage().getItemNameInCart(0);
        StepdefData.getCartPage().goToProductPage();
        Assertions.assertEquals(StepdefData.getInventoryPage().getInventoryElementName(0), productName);
    }

    @And("I click on remove button")
    public void iClickOnRemoveButton() {
        StepdefData.getIndividualItemPage().removeItemFromCart();
    }

    @And("I go to cart page")
    public void iGoToCartPage() {
        StepdefData.getIndividualItemPage().goToCartPage();
    }

    @Then("Cart icon shows zero items")
    public void cartIconShowsZeroItems() {
        Assertions.assertEquals(0, StepdefData.getIndividualItemPage().getNumberOfCartItems());
    }

    @Then("The cart is empty")
    public void theCartIsEmpty() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> StepdefData.getCartPage().getItemNameInCart(0));
    }

    //Inventory
    @When("I click on add to cart for an item")
    public void iClickOnAddToCartForAnItem() {
        StepdefData.getInventoryPage().addToCart(0);
    }

    @Then("the item is added to the basket")
    public void theItemIsAddedToTheBasket() {
        StepdefData.getInventoryPage().goToCart();
        Assertions.assertEquals("Sauce Labs Backpack", StepdefData.getCartPage().getItemNameInCart(0));
    }

    @Then("the add to cart button is changed to remove")
    public void theAddToCartButtonIsChangedToRemove() {
        Assertions.assertEquals("REMOVE", StepdefData.getInventoryPage().getInventoryElement(0).getText().substring(
                StepdefData.getInventoryPage().getInventoryElement(0).getText().length()-6));
    }

    @When("I click to return to the inventory page")
    public void iClickToReturnToTheInventoryPage() {
        StepdefData.getInventoryPage().returnToShop();
    } //Default use of InventoryPage

    //@Then("I will be on the inventory page")
    //public void iWillBeOnTheInventoryPage() {
    //    Assertions.assertInstanceOf(SLInventoryPage.class, sitePage);
    //}

    //Purchase
    @And("I am on the cart page")
    public void iAmOnTheCartPage() {
        StepdefData.getInventoryPage().goToCart();
    }

    @When("I click on checkout")
    public void iClickOnCheckout() {
        StepdefData.getCartPage().goToCheckoutStep1Page();
    }

    @Then("I am prompted to put in details")
    public void iAmPromptedToPutInDetails() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", StepdefData.getInventoryPage().getURL()); //Default use of InventoryPage
    }

    @And("I am going through with a purchase")
    public void iAmGoingThroughWithAPurchase() {
        StepdefData.getCartPage().goToCheckoutStep1Page();
    }

    @When("I confirm my purchase")
    public void iConfirmMyPurchase() {
        StepdefData.getCheckoutStep1Page().goToCheckoutStep2Page();
    }

    @Then("The website should thank me for my order, and say it is on it’s way.")
    public void theWebsiteShouldThankMeForMyOrderAndSayItIsOnItSWay() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", StepdefData.getInventoryPage().getURL()); //Default use of InventoryPage
    }

    @Then("I will be on the inventory page")
    public void iWillBeOnTheInventoryPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", StepdefData.getInventoryPage().getURL()); //Technically Default use of InventoryPage
    }

    @And("I add the first item to the cart")
    public void iAddTheFirstItemToTheCart() {
        StepdefData.getInventoryPage().addToCart(0);
    }

    @And("I add the two item to the cart")
    public void iAddTheTwoItemToTheCart() {
        StepdefData.getInventoryPage().addToCart(1);
    }

    @And("I add the three item to the cart")
    public void iAddTheThreeItemToTheCart() {
        StepdefData.getInventoryPage().addToCart(2);
    }
}
