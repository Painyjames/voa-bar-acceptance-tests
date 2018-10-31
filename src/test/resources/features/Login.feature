@login
Feature: Tests Successful And failed login conditions on Autobars
  User stories covered :-
  ABARS-1 Login
  ABARS-314 Redesign - Login
  ABARS-253 Logout

  Scenario Outline: : As a BA user, I should be able to login successfully with valid credentials
    Given User is on the Autobars login page
    And I enter a <username>
    And I enter <password>
    And I click Signin button
    Then Welcome page is displayed
    And Message displayed is : <msg>

    Examples:
      | username | password    | msg                          |
      | "ba6950" | "zot003ret" | "Welcome, Vale of Glamorgan" |

  # This test is not currently possible in test environments as password not validated
#  Scenario Outline: : As a BA user, I should NOT be able to login successfully with invalid credentials
#    Given User is on the Autobars login page
#    And I enter a <username>
#    And I enter <password>
#    And I click Signin button
#    Then Login page is displayed
#    And the error message should be "Login failed"
#    And the error message should be "Your username or password have not been recognised."
#    And the error message should be "Please verify them and try again."

#    Examples:
#      | username | password   |
#      | "ba6950" | "whatever" |

  Scenario Outline: : An invalid BA user, I should NOT be able to login successfully
    Given User is on the Autobars login page
    And I enter a <username>
    And I enter <password>
    And I click Signin button
    Then the error message should be "There’s been a problem"
    And the error message should be "Check the following"
    And the error message should be "Invalid Login Details"

    Examples:
      | username   | password   |
      | "whatever" | "whatever" |

  Scenario Outline: : As a BA user, I should NOT be able to login successfully without a password
    Given User is on the Autobars login page
    And I enter a <username>
    And I click Signin button
    Then Login page is displayed
    Then the error message should be "There’s been a problem"
    And the error message should be "Check the following"
    And the error message should "Enter password" appear next to "error-message-password-input"

    Examples:
      | username |
      | "ba6950" |