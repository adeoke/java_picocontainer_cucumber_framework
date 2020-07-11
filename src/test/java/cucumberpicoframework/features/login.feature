Feature: Login to the site
  Some junk

  Scenario: Create an Account
    And the user initiates the account creation process from the homepage
    When the user provides the required account registration details
    Then the user account is registered
    And adds the most expensive item to the cart
    When the user logs out
    And logs back in again
    Then the dress is still present in the cart


