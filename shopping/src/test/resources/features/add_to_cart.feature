Feature: Add to Cart

  Background:
    Given the product prices are:
      | product   | price  |
      | banana    | $1.20  |
      | orange    | $1.30  |

  Scenario: Add One Item
    When I add 1 "banana" to my cart
    Then the total price should be $1.20

  Scenario: Add Multiple Items
    When I add 1 "banana" to my cart
    And I add 2 "orange"s to my cart
    Then the total price should be $3.80