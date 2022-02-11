@All
Feature: This feature file to test the functionality related to login.

  Scenario: Verify user can login.
    Given user open websites
    When  user do login
    Then  verify user is on homepage