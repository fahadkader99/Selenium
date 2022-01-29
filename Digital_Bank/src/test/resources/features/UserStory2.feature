Feature: This feature is to test the ability of user to create a new Checking account so the user can process their payment.

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


   Scenario: Verify under BANKING ACCOUNTS section, clicking on ‘Checking’ dropdown should be displayed with following options: View Checking, New Checking
     When user move to left side menu bar
     And  user click on ‘Checking’ dropdown
     Then the dropdown should be displayed with following options: View Checking, New Checking
     And  verify the above options are displayed.
     And  user close the window

   Scenario: Verify after clicking on ‘New Checking’ option, should redirect user to a new page.
     When user move to the "Checking" dropdown menu on the left menu side and click on it
     And  user is able to see "View Checking" and "New Checking" option
     When user clicks on "New Checking" option.
     Then user is redirected to "http://3.129.60.236:8080/bank/account/checking-add"


   Scenario: verify user is able to see "Select Checking Account Type" with the following options: Standard Checking, Interest Checking
     When user is navigated to the "Create Checking" page
     Then user is able to see "Select Checking Account Type" with the following options: Standard Checking, Interest Checking
     And  user needs to pick any one of the radio button as all radio button are unchecked by default

   Scenario: verify user is able to see “Select Account Ownership” with the following radio button options: Individual, Joint
     When user is navigated to the "Create Checking" page
     Then user is able to see “Select Account Ownership” with the following radio button options: Individual, Joint
     And  user need to pick any one of the Radio button option as all Radio buttons should be unchecked by default

   Scenario: User is able to an Input filed “Account Name”.
     When user is navigated to the "Create Checking" page
     Then user is able to an Input filed “Account Name”
     And  user is able to enter texts in the input box which only takes alphanumeric and special characters.

   Scenario: User is able to see an Input filed “Initial Deposit Amount”
     When user is navigated to the "Create Checking" page
     Then verify user is able to see an Input filed “Initial Deposit Amount”
     And  user is able to enter minimum deposit amount.
     And  initial deposit amount filed only accepts numeric whole or decimal values.

   Scenario: Verify user is able to interact with "Submit" button.
     When user is navigated to the "Create Checking" page
     And  user filled up all the information
     Then user is able to see "Submit" button and clicking on it should successfully create an account
     And  after clicking user will be redirected to page to view checking account


   Scenario:  Verify user is able to interact with "Reset" button.
     When user is navigated to the "Create Checking" page
     And  user filled up all the information
     Then user is able to see "Reset" button
     When user click on "Reset " button it should reset all filled values to default state









