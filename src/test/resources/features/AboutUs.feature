Feature: As a shopper, I want to be able to access the company's social media pages and find out information about the company.

  Background: Having logged in
    Given I am logged in

  Scenario: Accessing company twitter page
    When I click on the twitter icon
    Then I go to the company's twitter page

  Scenario: Accessing company facebook page
    When I click on the facebook icon
    Then I go to the company's facebook page

  Scenario: Accessing company linkedin page
    When I click on the linkedin icon
    Then I go to the company's linkedin page