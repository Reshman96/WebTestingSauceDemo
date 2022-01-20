Feature: As a shopper I want to be able to add or remove my product from cart

  Background: Starting on individual item page and logged in
    Given I am logged in
    And I am on the individual item page

    Scenario: Adding an item to the cart
      When I click on add to cart button
      Then The item is added to the basket

      Scenario: Removing an item from the cart
        When I click on add to cart button
        And I click on remove button
        Then The item is removed from the basket

