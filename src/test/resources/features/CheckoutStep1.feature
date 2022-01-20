Feature: As a shopper, I want to be able to give my personal details to be able to provide an address for the order to be delivered to

  Background: Starting on the checkoutStep1 page and logged in
    Given I am logged in
    And I am on checkoutStep1 page

  Scenario: Blank first name field
    When The first name field is empty
    And I click on continue
    Then The website should give me an error saying "first name is required"

  Scenario: Blank last name field
    When The last name field is empty
    And The first name field is filled
    And I click on continue
    Then The website should give me an error saying "last name is required"

  Scenario: Blank postal code field
    When The postal code field is empty
    And The first name field is filled
    And The last name field is filled
    And I click on continue
    Then The website should give me an error saying "postal code is required"

  Scenario: All fields are filled
    When The first name field is filled
    And The last name field is filled
    And The postal code field is filled
    And I click on continue
    Then I should go to checkoutStep2 page