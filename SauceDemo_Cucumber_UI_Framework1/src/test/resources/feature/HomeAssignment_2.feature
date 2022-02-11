@All
Feature: This Feature is is to test that user is able to add item in cart and also able to remove item from there cart successfully

  @Assignment
  Scenario: Verify user is able to add and remove item from there cart and application behave as expected.

    Given user open websites
    When user do login
    Then verify user is on homepage
    When user click on item Sauce Labs Bike Light
    Then verify user is on Bike Light product detail page
    When user clicks on Bike Light add to cart button
    Then user clicks on Bike Light cart icon
    And  verify user is on cart page
    Then user clicks on Bike Light remove button
    When user clicks on checkout button
    When user fill all details on checkout page
    And  click on continue button on checkout page
    Then verify user is on review page
    And user click on finish button
    Then verify user is on order confirmation page
