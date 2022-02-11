@All
Feature: This feature is to test end to end flow of the website.

  Dev - Fahad
  Qa - Jahan
  Reviewed By - Chirag

  @Smoke
  Scenario: Verify user can place order
    Given user open websites
    When user do login
    Then verify user is on homepage
    When user click on any item
    Then verify user is on product detail page
    When user clicks on add to cart button
    And  click on cart icon
    Then verify user is on cart page
    When user clicks on checkout button
    Then verify user is on checkout page
    When user fill all details on checkout page
    And  click on continue button on checkout page
    Then verify user is on review page
    When user click on finish button
    Then verify user is on order confirmation page
    And  verify order confirmation message