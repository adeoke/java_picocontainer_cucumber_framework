Feature: Account

  Scenario: Add item to cart, checking that logging out and in again keeps cart items
    Given the user initiates the account creation process from the homepage
    When the user provides the required account registration details
    Then the user account is registered
    And adds the most expensive item to the cart
    When the user logs out
    And logs back in again
    Then the dress is still present in the cart


