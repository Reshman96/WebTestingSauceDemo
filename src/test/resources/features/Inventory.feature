Feature: As a shopper I want to be able to add and remove from the cart
  Background: Starting on the inventory page and logged in
    Given I am logged in
    And I am on the Inventory page
  Scenario: Adding an item to the cart
    When I click on add to cart for an item
    Then the item is added to the basket
  Scenario: Removing an item from the cart
    When I click on add to cart button for any item
    Then the add to cart button is changed to remove