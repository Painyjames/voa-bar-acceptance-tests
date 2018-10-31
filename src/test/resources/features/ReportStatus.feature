@reportStatus
Feature: Tests Report Status screen features

  Scenario Outline: As a BA user, I should be able to navigate to and verify the text on the report status page
    Given User is on the Autobars login page
    And I enter a <username>
    And I enter <password>
    And I click Signin button
    Then Welcome page is displayed
    And Council Tax link should be shown
    When I click on Council Tax link
    Then Council tax page should be shown
    And I click on the previous submissions link
    Then Report status page is displayed
    And Message displayed is : <msg1>
    And Message displayed is : <msg2>
    And Failed submissions link is displayed
    And Completed submissions link is displayed

    Examples:
      | username | password    | msg1                        | msg2                                    |
      | "ba6950" | "zot003ret" | "Billing Authority Reports" | "Submission history, Vale of Glamorgan" |

  Scenario Outline: As a BA user, I should be able to logout from report status page
    Given User is on the Autobars login page
    And I enter a <username>
    And I enter <password>
    And I click Signin button
    Then Welcome page is displayed
    And Council Tax link should be shown
    When I click on Council Tax link
    Then Council tax page should be shown
    And I click on the previous submissions link
    Then Report status page is displayed
    And logout button should be displayed
    And <council> should be displayed beside logout button
    When logout button is clicked
    Then Login page is displayed

    Examples:
      | username | password    | council             |
      | "ba6950" | "zot003ret" | "Vale of Glamorgan" |