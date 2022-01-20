Feature: As a shopper, I want to be able to go to the basket page from any other page.
  Background: Having logged in
    Given I am logged in

  Scenario: Accessing basket from inventory page
    And Im on the inventory page
    When I click the basket
    Then I should be able to view whats in my basket

  Scenario: Accessing basket from product page
    And I am on the individual item page
    When I click the basket
    Then I should be able to view whats in my basket

  Scenario: Accessing basket from checkout step 1 page
    And Im on the checkout step 1 page
    When I click the basket
    Then I should be able to view whats in my basket

  Scenario: Accessing basket from checkout step 2 page
    And Im on the checkout step 2 page
    When I click the basket
    Then I should be able to view whats in my basket


