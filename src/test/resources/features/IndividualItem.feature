Feature: As a shopper I want to be able to add or remove my product from cart from the individual item's page

  Background: Starting on individual item page and logged in
    Given I am logged in
    And I am on the individual item page

  Scenario: Adding an item to empty cart
    When I click on add to cart button
    Then Cart icon shows one item

  Scenario: Adding an item to empty cart
    When I click on add to cart button
    And I click on cart image
    Then My item is in the cart

  Scenario: Removing an item from the cart (icon)
    When I click on add to cart button
    And I click on remove button
    Then Cart icon shows zero items

  Scenario: Removing an item from the cart
    When I click on add to cart button
    And I click on remove button
    And I click on cart image
    Then The cart is empty

    Scenario: Go to cart page
      When I click on cart image
      Then I am on the cart page