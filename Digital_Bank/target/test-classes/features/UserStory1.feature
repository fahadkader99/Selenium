Feature: This feature is to test if user is able to test all details of his account home page.

  Developer - Alexandr
  Tester - Tatiana
  Reviewed by Gia

  Background:
    Given user open website "http://3.129.60.236:8080/bank/login"
    And user is on login page
    When user enters username "ash@gmail.com"
    And user enters password "Java12345[]"
    When user click on login button
    Then user is navigate to the bank homepage


  Scenario: Verify user is able to view Welcome Message.

    And Verify "Welcome (First_name)" is displayed on the right top header.
    And user stays logged in
    And user close the browser


  Scenario: Verify user is able to view BANKING ACCOUNTS title
    And verify BANKING ACCOUNTS title is present
    When user navigate to left side menu bar
    And verify following items are present: Checking, Saving, Transactions
    And user close the browser

  Scenario: Verify user is able to view CREDIT ACCOUNTS title
    And Verify CREDIT ACCOUNTS title is present
    When user navigate to left side menu bar
    Then verify the following item is present: Digital Credit
    And user close the browser

  Scenario: Verify user is able to view TRANSFERS / PAYMENTS title
    And Verify TRANSFERS PAYMENTS title is present
    When user navigate to left side menu bar
    Then verify the following item is present: Transfer
    And user close the browser

   Scenario: Verify user is able to view 3RD PARTY TRANSFERS title
     And Verify 3RD PARTY TRANSFERS title is present
     When user navigate to left side menu bar
     Then verify the following item is present: VISA Direct
     And user close the browser




