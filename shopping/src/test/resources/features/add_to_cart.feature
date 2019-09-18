Feature: Add to Cart

  Scenario: Add One Item
    Given the price of a "banana" is $0.20
    When I add 1 "banana" to my cart
    Then the total price should be $0.20

  Scenario: Add Multiple Items
    Given the price of a "banana" is $1.20
    And the price of a "orange" is $1.30
    When I add 1 "banana" to my cart
    And I add 2 "orange"s to my cart
    Then the total price should be $3.80