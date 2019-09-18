Feature: Checkout

  Scenario: Checkout One Item
    Given the price of a "banana" is $0.20
    When I checkout with 1 "banana"
    Then the total price should be $0.20

  Scenario: Checkout Multiple Items
    Given the price of a "banana" is $1.20
    Given the price of a "orange" is $1.30
    When I checkout with 1 "banana"
    And I checkout with 2 "orange"s
    Then the total price should be $3.80