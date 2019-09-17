Feature: Checkout

  Scenario: Checkout One Item
    Given the price of a "banana" is $0.20
    When I checkout with 1 "banana"
    Then the total price should be $0.20