package org.bddTest.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.DriversFactory;
import org.junit.jupiter.api.Assertions;
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

    @Before
    public void setup() {
        StepDefsUtil.setup();
        driver = StepDefsUtil.driver;
        loginPage = new SlLoginPage(driver);
    }

    //CheckoutStep1Stepdefs
    @And("I am on checkoutStep1 page")
    public void iAmOnCheckoutStepPage1() {
         sitePage = loginPage.Login("standard_user", "secret_sauce")
                 .goToCart()
                 .goToCheckoutStep1Page();
    }

    @And("I click on continue")
    public void iClickOnContinue() {
        checkoutStep1Page.clickContinueButton();
    }

    //ConfirmationStepdefs

    @And("I am on the confirmation page")
    public void iAmOnTheConfirmationPage() {
        sitePage = loginPage.Login("standard_user", "secret_sauce");
        sitePage = inventoryPage.goToCart()
                .goToCheckoutStep1Page()
                .goToCheckoutStep2Page()
                .goToConfirmationPage();
    }

    @When("I click on back home")
    public void iClickOnBackHome() {
        confirmationPage.returnToInventoryPage();
    }

    //EveryPage
    @Given("Im on the inventory page")
    public void imOnTheInventoryPage() {
        sitePage = new SlLoginPage(driver).StandardUserLogin();
    }

    @Given("Im on the product page")
    public void imOnTheProductPage() {
        sitePage = new SlLoginPage(driver).StandardUserLogin().goToItem(1);
    }

    @Given("Im on the checkout step 1 page")
    public void imOnTheCheckoutStep1Page() {
        sitePage = new SlLoginPage(driver).StandardUserLogin().goToCart().goToCheckoutStep1Page();
    }

    @Given("Im on the checkout step 2 page")
    public void imOnTheCheckoutStep2Page() {
        sitePage = new SlLoginPage(driver)
                .StandardUserLogin()
                .goToCart()
                .goToCheckoutStep1Page()
                .goToCheckoutStep2Page();
    }

    @When("I click the basket")
    public void iClickTheBasket() {
        sitePage = sitePage.goToCart();
    }

    //Individual
    @And("I am on the individual item page")
    public void iAmOnTheIndividualItemPage() {
        sitePage = inventoryPage.goToItem(0);
        //String productName = individualItemPage.getProductName();
    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        individualItemPage.addItemToCart();
    }

    @Then("Cart icon shows one item")
    public void cartIconShowsOneItem() {
        Assertions.assertTrue(individualItemPage.getNumberOfCartItems()==1);
    }

    @Then("My item is in the cart")
    public void myItemIsInTheCart() {
        String productName = individualItemPage.getProductName();
        Assertions.assertEquals(productName, cartPage.getItemNameInCart(0));
    }

    @And("I click on remove button")
    public void iClickOnRemoveButton() {
        individualItemPage.removeItemFromCart();
    }

    @And("I go to cart page")
    public void iGoToCartPage() {
        sitePage = individualItemPage.goToCartPage();
    }

    @Then("Cart icon shows zero items")
    public void cartIconShowsZeroItems() {
        Assertions.assertTrue(individualItemPage.getNumberOfCartItems()==0);
    }

    @Then("The cart is empty")
    public void theCartIsEmpty() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> cartPage.getItemNameInCart(0));
    }

    //Inventory

    @And("I am on the Inventory page")
    public void iAmOnTheInventoryPage() {
        driver = StepDefsUtil.driver;
        //should be able to assign inventory page as we should be logged in
        inventoryPage = new SLInventoryPage(driver);
        sitePage = new SitePage(driver) {}; //No way this is good practice.
    }

    @When("I click on add to cart for an item")
    public void iClickOnAddToCartForAnItem() {
        inventoryPage.addToCart(0);
    }

    @Then("the item is added to the basket")
    public void theItemIsAddedToTheBasket() {
        Assertions.assertEquals("Sauce Labs Backpack", sitePage.goToCart().getItemNameInCart(0));
    }

    @Then("the add to cart button is changed to remove")
    public void theAddToCartButtonIsChangedToRemove() {
        Assertions.assertEquals("REMOVE", inventoryPage.getInventoryElement(0).getText().substring(
                inventoryPage.getInventoryElement(0).getText().length()-6));
    }

    @When("I click to return to the inventory page")
    public void iClickToReturnToTheInventoryPage() {
        sitePage = sitePage.returnToShop();
    }

    @Then("I will be on the inventory page")
    public void iWillBeOnTheInventoryPage() {
        Assertions.assertInstanceOf(SLInventoryPage.class, sitePage);
    }

    //Purchase
    @And("I am on the cart page")
    public void iAmOnTheCartPage() {
        sitePage = inventoryPage.goToCart();
    }

    @When("I click on checkout")
    public void iClickOnCheckout() {
        sitePage = cartPage.goToCheckoutStep1Page();
    }

    @Then("I am prompted to put in details")
    public void iAmPromptedToPutInDetails() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", sitePage.getURL());
    }

    @And("I am going through with a purchase")
    public void iAmGoingThroughWithAPurchase() {
        sitePage = cartPage.goToCheckoutStep1Page();
    }

    @When("I confirm my purchase")
    public void iConfirmMyPurchase() {
        sitePage = checkoutStep1Page.goToCheckoutStep2Page();
    }

    @Then("The website should thank me for my order, and say it is on it’s way.")
    public void theWebsiteShouldThankMeForMyOrderAndSayItIsOnItSWay() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", sitePage.getURL());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
