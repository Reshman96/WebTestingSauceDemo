Feature: Example feature

Scenario: I want to add an item to the cart
  Given I am logged in
  When I add an item to the cart
  Then My item is in the cart

  Scenario: I want to purchase an item
    Given I am logged in
    And I click on the basket
    And I am going through with a purchase
    When I confirm my purchase
    Then The website should thank me for my order and say it is on the way

  Scenario: I want to purchase an item (Slower)
    Given I am logged in (Slowed down)
    And I add an item to the cart (Slowed down)
    And I click on the basket (Slowed down)
    And I am going through with a purchase (Slowed down)
    When I confirm my purchase (Slowed down)
    Then The website should thank me for my order and say it is on the way (Slowed down)