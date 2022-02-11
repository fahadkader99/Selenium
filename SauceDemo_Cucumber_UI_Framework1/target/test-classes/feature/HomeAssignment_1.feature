@All
Feature: This Feature is to test the cart functionality of the app

  @Assignment
  Scenario: Verify user is able to see there product on the cart
    Given user open websites
    When user do login
    Then verify user is on homepage
    When user click on item Sauce Labs Bike Light
    Then verify user is on Bike Light product detail page
    When user clicks on Bike Light add to cart button
    Then user clicks on Bike Light cart icon
    And  verify user is on cart page
    When user clicks on checkout button
    Then verify user is on checkout page
    When user fill all details on checkout page
    And  click on continue button on checkout page
    Then verify user is on review page
    When user clicks on cancel button
    Then verify user is on homepage
    And user clicks on homepage cart icon
    Then verify one item should be available in Cart