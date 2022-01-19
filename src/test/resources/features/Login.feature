Feature: As a shopper I want to be able to log in
  Background: Starting on the login page
    Given I am on the login page
  Scenario: Logging in with correct details
    When I enter valid username and password
    Then I will be logged in
  Scenario: Logging in with incorrect details
    When I provide incorrect username and password
    Then I will not be logged in
  Scenario: Logging in with a locked account
    When I enter valid username and password but the account is locked out
    Then I will not be logged in
  Scenario: Logging in without entering details
    When I leave the username or password box blank
    Then I will not be logged in