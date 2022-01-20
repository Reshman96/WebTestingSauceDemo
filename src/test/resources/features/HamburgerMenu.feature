Feature: As a shopper, I want to be able to interact with the Hamburger menu

  Background: Having logged in
    Given I am logged in

  Scenario: Accessing company's about page
    When I click on the about option on the Hamburger menu
    Then I go to the company's about page

  Scenario:
    When I click on the reset app state option on the Hamburger menu
    Then I remove all the items from the basket