Feature: As a shopper I want to be able to add and remove from the cart
  Background: Starting on the inventory page and logged in
    Given I am logged in
    And I am on the Inventory page

  Scenario: Adding an item to the cart
    When I click on add to cart for an item
    Then the item is added to the basket

  Scenario: Removing an item from the cart
    When I click on add to cart for an item
    Then the add to cart button is changed to remove

#Logout scenarios
  Scenario: Logout on the inventory page
    When I click on logout button
    Then I will be logged out

  Scenario: Logout on an individual item's page
    And I am on the individual item page
    When I click on logout button
    Then I will be logged out

  Scenario: Logout on the cart page
    And I am on the cart page
    When I click on logout button
    Then I will be logged out

  Scenario: Logout on the first step of the checkout
    And I am on the cart page
    And I click on checkout
    When I click on logout button
    Then I will be logged out

  Scenario: Logout on the second step of the checkout
    And I am on the cart page
    And I click on checkout
    And I confirm my purchase
    When I click on logout button
    Then I will be logged out

# Return to shop scenarios
  Scenario: Return to the shop from the cart page
    And I am on the cart page
    When I click to return to the inventory page
    Then I will be on the inventory page

  Scenario: Return to the shop from an individual item page
    And I am on the individual item page
    When I click to return to the inventory page
    Then I will be on the inventory page

  Scenario: Return to the shop from the first step of checkout page
    And I am on the cart page
    And I click on checkout
    When I click to return to the inventory page
    Then I will be on the inventory page

  Scenario: Return to the shop from the second step of checkout page
    And I am on the cart page
    And I click on checkout
    And I confirm my purchase
    When I click to return to the inventory page
    Then I will be on the inventory page