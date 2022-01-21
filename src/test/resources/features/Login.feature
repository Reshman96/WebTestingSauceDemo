Feature: As a shopper I want to be able to log in
  Background: Starting on the login page
    Given I am on the login page

  Scenario: Logging in with correct details
    When I enter a valid username and password
    Then I will be logged in

  Scenario: A valid user logs in and the images are correct
    When I enter a valid username and password
    Then the product images will be correct

  Scenario: Logging in with incorrect details
    When I provide an incorrect username and password
    Then I will not be logged in

  Scenario: Logging in with a locked account
    When I enter a valid username and password but the account is locked out
    Then I will not be logged in

  Scenario: Logging in without entering details
    When I leave the username or password box blank
    Then I will not be logged in

  Scenario: Logging in with a problem account
    When I enter a valid username and password but the account is a problem user
    Then I will be logged in

  Scenario: A problem user logs in and the images are wrong
    When I enter a valid username and password but the account is a problem user
    Then the product images will be wrong

  Scenario: Logging in with a glitched account
    When I enter a valid username and password but the account is a performance glitch user
    Then I will be logged in