package org.bddTest.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.PomUtility;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class NonCoreStepdefs {
    private WebDriver driver;
    private String twitterURL, facebookURL, linkedInURL;

    @Before(order = 2)
    public void setup() {
        driver = StepDefsUtil.driver;
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
        StepdefData.getCheckoutStep1Page().setFirstName("");
    }

    @When("The last name field is empty")
    public void theLastNameFieldIsEmpty() {
        StepdefData.getCheckoutStep1Page().setLastName("");
    }

    @When("The postal code field is empty")
    public void thePostalCodeFieldIsEmpty() {
        StepdefData.getCheckoutStep1Page().setPostalCode("");
    }

    @And("The first name field is filled")
    public void theFirstNameFieldIsFilled() {
        StepdefData.getCheckoutStep1Page().setFirstName("Luciano");
    }

    @And("The last name field is filled")
    public void theLastNameFieldIsFilled() {
        StepdefData.getCheckoutStep1Page().setLastName("Big Tuna");
    }

    @And("The postal code field is filled")
    public void thePostalCodeFieldIsFilled() {
        StepdefData.getCheckoutStep1Page().setPostalCode("0123");
    }

    @When("I click on logout button")
    public void iClickOnLogoutButton() {
        StepdefData.getInventoryPage().logout();
    }

    @Then("I will be logged out")
    public void iWillBeLoggedOut() {
        Assertions.assertEquals("https://www.saucedemo.com/", StepdefData.getLoginPage().getURL());
    }

    @When("I click on the twitter icon")
    public void iClickOnTheTwitterIcon() {
        twitterURL = StepdefData.getInventoryPage().goToTwitterPage();
    }

    @Then("I go to the company's twitter page")
    public void iGoToTheCompanySTwitterPage() {
        Assertions.assertEquals("https://twitter.com/saucelabs", twitterURL);
    }

    @When("I click on the facebook icon")
    public void iClickOnTheFacebookIcon() {
        facebookURL = StepdefData.getInventoryPage().goToFacebookPage();
    }

    @Then("I go to the company's facebook page")
    public void iGoToTheCompanySFacebookPage() {
        Assertions.assertEquals("https://www.facebook.com/saucelabs", facebookURL);
    }

    @When("I click on the linkedin icon")
    public void iClickOnTheLinkedinIcon() {
        linkedInURL = StepdefData.getInventoryPage().goToLinkedInPage();
    }

    @Then("I go to the company's linkedin page")
    public void iGoToTheCompanySLinkedinPage() {
        Assertions.assertEquals("https://www.linkedin.com/company/sauce-labs/", linkedInURL);
    }

    @When("I click on the about option on the Hamburger menu")
    public void iClickOnTheAboutOptionOnTheHamburgerMenu() {
        StepdefData.getInventoryPage().goToCompanyPage();
    }

    @Then("I go to the company's about page")
    public void iGoToTheCompanySAboutPage() {
        Assertions.assertEquals("https://saucelabs.com/", StepdefData.getInventoryPage().getURL());
    }

    @When("I click on the reset app state option on the Hamburger menu")
    public void iClickOnTheResetAppStateOptionOnTheHamburgerMenu() {
        StepdefData.getInventoryPage().resetAppState();
    }

    @Then("I remove all the items from the basket")
    public void iRemoveAllTheItemsFromTheBasket() {
        Assertions.assertEquals(0, StepdefData.getInventoryPage().getNumberOfCartItems());
    }

    @Then("I should be able to view whats in my basket")
    public void iShouldBeAbleToViewWhatsInMyBasket() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", StepdefData.getCartPage().getURL());
    }

    @Then("I should go to the checkout step 2 page")
    public void iShouldGoToCheckoutStep2Page() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", StepdefData.getCheckoutStep2Page().getURL());
    }

    @When("I click on the first item in checkoutStep2")
    public void iClickOnTheFirstItemInCheckoutStep2() {
        StepdefData.getInventoryPage().goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().goToIndividualItemPage(0);
    }

    @Then("I go to the individual item page")
    public void iGoToTheIndividualItemPage() {
        Assertions.assertTrue(StepdefData.getIndividualItemPage().getURL().contains("https://www.saucedemo.com/inventory-item.html?id="));
    }

    @When("I click on the second item in checkoutStep2")
    public void iClickOnTheSecondItemInCheckoutStep2() {
        StepdefData.getInventoryPage().goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().goToIndividualItemPage(1);
    }

    @When("I click on the third item in checkoutStep2")
    public void iClickOnTheThirdItemInCheckoutStep2() {
        StepdefData.getInventoryPage().goToCart().goToCheckoutStep1Page().goToCheckoutStep2Page().goToIndividualItemPage(2);
    }

    @And("I click to reset the app state")
    public void iClickToResetTheAppState() {
        StepdefData.getInventoryPage().resetAppState();
    }

    @Then("The page state will be reset")
    public void thePageStateWillBeReset() {
        Assertions.assertEquals(0, StepdefData.getInventoryPage().goToCart().getNumberOfCartItems());
    }

    //EXAMPLE ONES//////////////////////////////

    @Given("I am logged in \\(Slowed down)")
    public void iAmLoggedInSlowedDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StepdefData.getLoginPage().StandardUserLogin();
    }

    @And("I click on the basket \\(Slowed down)")
    public void iClickOnTheBasketSlowedDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StepdefData.getInventoryPage().goToCart(); //Default use of InventoryPage
    }

    @And("I am going through with a purchase \\(Slowed down)")
    public void iAmGoingThroughWithAPurchaseSlowedDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StepdefData.getCartPage().goToCheckoutStep1Page();
    }

    @When("I confirm my purchase \\(Slowed down)")
    public void iConfirmMyPurchaseSlowedDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StepdefData.getCheckoutStep1Page().goToCheckoutStep2Page();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StepdefData.getCheckoutStep2Page().goToConfirmationPage();
    }

    @Then("The website should thank me for my order and say it is on the way \\(Slowed down)")
    public void theWebsiteShouldThankMeForMyOrderAndSayItIsOnTheWaySlowedDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", StepdefData.getInventoryPage().getURL()); //Default use of InventoryPage
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I add an item to the cart \\(Slowed down)")
    public void iAddAnItemToTheCartSlowedDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StepdefData.getInventoryPage().addToCart(0);
    }
    /////////////////////////////////////////////////////////////////////////////////////
}
