package org.bddTest.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.DriversFactory;
import org.PomUtility;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.*;
import org.pom.inventoryPage.SLInventoryPage;

public class EveryPageStepdefs {
    private WebDriver driver;
    private SitePage sitePage;
    private SLCartPage cartPage;
    @Before
    public void setup() {
        DriversFactory.driverLoader(DriversFactory.BrowsersEnums.CHROME);
        driver = StepDefsUtil.driver;
    }
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

    @Then("I should be able to view whats in my basket")
    public void iShouldBeAbleToViewWhatsInMyBasket() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", sitePage.getURL());
    }


}
