Feature: Shopping Cart Price Total

  Shopper would like to know the total cost of the
  contents in their shopping cart as they shop so
  they can predict and control their spending

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

  Scenario: Add Item With No Price
    Then add item to my cart should fail
    When I add 1 "kiwi" to my cart
