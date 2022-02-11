@All
Feature: This feature is to test user is able to oder multiple items on the website.

  Dev - Ashikul Kader
  Qa - Jahan
  Reviewed by - Chirag

  @Regression
  Scenario: Verify user can select multiple items and place order.
    Given user open websites
    When user do login
    Then verify user is on homepage
    When user click on item Sauce Labs Bike Light
    Then verify user is on Bike Light product detail page
    When user clicks on Bike Light add to cart button
    Then user clicks on Bike Light cart icon
    And  verify user is on cart page
    When user clicks on continue shopping
    Then user click on item Sauce Labs Bolt T-Shirt
    And  verify user is on T-Shirt product detail page
    Then user clicks on add to T-Shirt cart button
    When user clicks on T-Shirt cart icon
    And  Verify two items displayed on cart page
    When user clicks on checkout button
    Then verify user is on checkout page
    When user fill all details on checkout page
    And  click on continue button on checkout page
    Then verify user is on review page
    When user click on finish button
    Then verify user is on order confirmation page
    And  verify order confirmation message

