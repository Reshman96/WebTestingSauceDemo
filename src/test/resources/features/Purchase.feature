Feature: As a shopper I want to be able to purchase an item
  Background: Starting from the cart page and logged in
    Given I am logged in
    And I am on the cart page
  Scenario: Going to the checkout page from the cart page
    When I click on checkout
    Then I am prompted to put in details
  Scenario: Completing a purchase
    And I am going through with a purchase
    When I confirm my purchase
    Then The website should thank me for my order, and say it is on it’s way.