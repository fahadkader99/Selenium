@All
Feature: This feature is to test that user is able to login add item to cart, logout and login again to continue the order.

  @Assignment
  Scenario: Verify user is able to continue the order after logout

    Given user open websites
    When user do login
    Then verify user is on homepage
    When user click on item Sauce Labs Bike Light
    Then verify user is on Bike Light product detail page
    When user clicks on Bike Light add to cart button
    Then user clicks on Bike Light cart icon
    And  verify user is on cart page
    When user clicks on burger menu
    Then user click on logout link
    And user do login
    Then verify user is on homepage
    When user clicks on homepage cart icon
    And verify one item should be available in Cart