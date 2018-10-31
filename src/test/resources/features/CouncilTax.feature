@councilTax
Feature: Tests Council tax screen features
  User stories covered :-
  ABARS-317 REDESIGN -Council Tax
  ABARS-15 COUNCIL TAX

  #@test
  Scenario Outline: As a BA user, I should be able to navigate to and verify the text on the council tax page
    Given User is on the Autobars login page
    And I enter a <username>
    And I enter <password>
    And I click Signin button
    Then Welcome page is displayed
    And Council Tax link should be shown
    When I click on Council Tax link
    Then Council tax page should be shown
    And Start button is displayed
    And view previous submissions link is displayed
    When Start button is clicked
    Then Upload your council tax reports page is displayed

    Examples:
      | username | password    |
      | "ba6950" | "zot003ret" |

  Scenario Outline: As a BA user, I should be able to logout from council tax page
    Given User is on the Autobars login page
    And I enter a <username>
    And I enter <password>
    And I click Signin button
    Then Welcome page is displayed
    And Council Tax link should be shown
    When I click on Council Tax link
    Then Council tax page should be shown
    And logout button should be displayed
    And <council> should be displayed beside logout button
    When logout button is clicked
    Then Login page is displayed

    Examples:
      | username | password    | council             |
      | "ba6950" | "zot003ret" | "Vale of Glamorgan" |
