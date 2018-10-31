@welcome
Feature: Tests Welcome screen features
  User stories covered:-
  ABARS-66 WELCOME

  Scenario Outline: As a BA user, I should be able to view welcome screen when I login
    Given User is on the Autobars login page
    And I enter a <username>
    And I enter <password>
    And I click Signin button
    Then Welcome page is displayed
    And Message displayed is : <msg1>
    And Message displayed is : <msg2>
    And Council Tax link should be shown
    And logout button should be displayed
    And <council> should be displayed beside logout button
    When I click on Council Tax link
    Then Council tax page should be shown

    Examples:
      | username | password    | msg1                        | msg2                         | council             |
      | "ba6950" | "nuf005nem" | "Billing Authority Reports" | "Welcome, Vale of Glamorgan" | "Vale of Glamorgan" |

  Scenario Outline: As a BA user, I should be able to logout from welcome screen
    Given User is on the Autobars login page
    And I enter a <username>
    And I enter <password>
    And I click Signin button
    Then Welcome page is displayed
    When logout button is clicked
    Then Login page is displayed

    Examples:
      | username | password    |
      | "ba6950" | "nuf005nem" |
