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
        //needs SitePage implementation
    }

    @Then("I go to the company's twitter page")
    public void iGoToTheCompanySTwitterPage() {
        //needs SitePage implementation
    }

    @When("I click on the facebook icon")
    public void iClickOnTheFacebookIcon() {
        //needs SitePage implementation
    }

    @Then("I go to the company's facebook page")
    public void iGoToTheCompanySFacebookPage() {
        //needs SitePage implementation
    }

    @When("I click on the linkedin icon")
    public void iClickOnTheLinkedinIcon() {
        //needs SitePage implementation
    }

    @Then("I go to the company's linkedin page")
    public void iGoToTheCompanySLinkedinPage() {
        //needs SitePage implementation
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
        //needs SitePage implementation
    }

    @Then("I should be able to view whats in my basket")
    public void iShouldBeAbleToViewWhatsInMyBasket() {
        //needs SitePage implementation
    }

    @Then("I should go to the checkout step 2 page")
    public void iShouldGoToCheckoutStep2Page() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", StepdefData.getCheckoutStep2Page().getURL());
    }

    @And("I click to reset the app state")
    public void iClickToResetTheAppState() {
        StepdefData.getInventoryPage().resetAppState();
    }

    @Then("The page state will be reset")
    public void thePageStateWillBeReset() {
        Assertions.assertEquals(0, StepdefData.getInventoryPage().goToCart().getNumberOfCartItems());
    }
}