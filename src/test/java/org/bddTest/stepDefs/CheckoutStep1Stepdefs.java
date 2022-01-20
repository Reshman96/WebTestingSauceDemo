package org.bddTest.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.DriversFactory;
import org.PomUtility;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.SLCheckoutStep1Page;
import org.pom.SlLoginPage;

public class CheckoutStep1Stepdefs {
    private WebDriver driver;
    private SlLoginPage loginPage;
    private SLCheckoutStep1Page checkoutStep1Page;

    @Before
    public void setup() {
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.CHROME);
        driver = new ChromeDriver();
        loginPage = new SlLoginPage(driver);
    }

    @And("I am on checkoutStep1 page")
    public void iAmOnCheckoutStepPage1() {
        checkoutStep1Page = loginPage.Login("standard_user", "secret_sauce").goToCart().goToCheckoutStep1Page();
    }

    @And("I click on continue")
    public void iClickOnContinue() {
        checkoutStep1Page.clickContinueButton();
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
        checkoutStep1Page.setFirstName("");
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

    @Then("I should go to checkoutStep2 page")
    public void iShouldGoToCheckoutStepPage2() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-two.html", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
