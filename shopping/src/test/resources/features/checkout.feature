Feature: Checkout

  Scenario: Checkout One Item
    Given the price of a "banana" is 20 cents
    When I checkout with 1 "banana"
    Then the total price should be 20 cents