Feature: As a shopper, I want to be able to view each individual item midway through my checkout.

  Background:
    Given I am logged in
    And I add the first item to the cart
    And I add the second item to the cart
    And I add the third item to the cart
    And I am on the cart page
    And I am on the checkout step 1 page
    And I am on the checkout step 2 page

    Scenario:
      When I click on the first item in checkoutStep2
      Then I go to the individual item page

      Scenario:
      When I click on the second item in checkoutStep2
      Then I go to the individual item page

      Scenario:
      When I click on the third item in checkoutStep2
      Then I go to the individual item page