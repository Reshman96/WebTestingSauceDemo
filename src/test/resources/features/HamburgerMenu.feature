Feature: As a shopper, I want to be able to interact with the Hamburger menu

  Background: Having logged in
    Given I am logged in

  Scenario: Accessing company's about page
    When I click on the about option on the Hamburger menu
    Then I go to the company's about page

  Scenario:
    When I click on the reset app state option on the Hamburger menu
    Then I remove all the items from the basket

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

    #Reset app state scenarios
  Scenario: I click on reset app state
    And I click on add to cart button
    When I click to reset the app state
    Then The page state will be reset