Feature: Create new Savings Bank account nd process payment from user's preferred account

  Background:
    Given user open website
    Then  verify user is at the login page
    And   user input valid credentials
    When  user clicks on the sign in button
    Then  verify user is navigated to home page


  Scenario Outline: User is able to Interact with savings tab
    When user clicks on "savings" dropdown
    Then verify "<SavingsCategories>" are available
    Examples:
      | SavingsCategories |
      | view-savings      |
      | new-savings       |

  Scenario Outline: Verify User can create New Savings account
    When user clicks on "savings" dropdown
    And  user select "new-savings" option
    Then user should be redirected to Create Savings page
    And user should be able to see Savings Account Form Fields
    Then Verify "<Select Savings Account Type>" is visible

    Examples:
      | Select Savings Account Type |
      | Savings                     |
      | Money Market                |


  Scenario Outline: Select Account Ownership categories verification
    Given user clicks on "savings" dropdown
    When user select "new-savings" option
    When user should be redirected to Create Savings page
    Then user should be able to see Select Account Ownership
    And  verify "<SelectAccountOwnership>" is visible at New Savings Page
    Examples:
      | SelectAccountOwnership |
      | Individual             |
      | Joint                  |

# Passing multiple Strings to a input filed ::: StringBuilder + AsLists

  Scenario: Account Name element Verification
    Given user clicks on "savings" dropdown
    When user select "new-savings" option
    When user should be redirected to Create Savings page
    Then user should be able to see Account Name Field
    When user should sends the following details
      | alphanumeric and special character |
      | Fahad 123                          |
      | Kader 45&#@                        |
      | Esrat Jahan                        |
      | Sani JAHAN                         |
      | J&*#hn is Not HA$$Y                |


  Scenario Outline: Initial Deposit Amount element verification
    Given user clicks on "savings" dropdown
    When user select "new-savings" option
    When user should be redirected to Create Savings page
    Then user should be able to see line Initial Deposit Amount
    And  user should be able to input "<1000>" to be deposited
    Examples:
      | 1000 |
      | 100  |
      | 200  |
      | 300  |
      | 400  |
      | 500  |


  Scenario: Create New Savings Account End to End Verification

    Given user clicks on "savings" dropdown
    When  user select "new-savings" option
    When  user is on Create Savings page
    Then  user select Savings Account Type
    And   user select Joint
    Then  user enter TestName on the Account Name field
    And   user should be able to input $200 to be deposited
    When  user clicks on Submit button
    Then  verify user is redirected to the View Savings Page
