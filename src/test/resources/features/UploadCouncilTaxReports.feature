@upload
Feature: upload council tax feature
  User stories covered:-
  ABARS-53 ATTACH XML FILE (File Explorer)
  ABARS-15 COUNCIL TAX

  Scenario Outline: As a BA user I should be able to upload a valid xml report from upload council tax page
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
    And choose a file button is displayed
    And "Files must be in XML format" message should be shown
    And "Multiple reports can be contained in a single file" message should be shown
    And "Only one file can be selected at a time" message should be shown
    And "Previous XML files should not be resubmitted" message should be shown
    And "If you wish to supply additional information, please email BARS@voa.gsi.gov.uk" message should be shown
    And "To support your reports, please include the billing authority report number in the subject of your email." message should be shown
    When <file> is uploaded
    And Submit is clicked
    Then Confirmation page should be shown with <msg1>
    And Download receipt button is displayed
    And "We have received your file and have processed it successfully." message should be shown
    And Upload more Council Tax reports link is displayed
    When I click on the previous submissions link
    And The first submission report status is <status>
    And The first submission report download receipt button is displayed
    #And Message displayed is : <msg2>

    Examples:
      | username | password    | file                                              | msg1              | status |
      | "ba6950" | "zot003ret" | "/testData/SystemTestFiles/singleValidBA6950.xml" | "Submission DONE" | "DONE" |
@test
  Scenario Outline:As a BA user I should NOT be able to upload an invalid (non xml) report from upload council tax page
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
    And choose a file button is displayed
    When <file> is uploaded
    And Submit is clicked
    Then Confirmation page should be shown with <msg1>
    And Download receipt button is displayed
    And "We have received your file and have processed it unsuccessfully." message should be shown
    And Upload more Council Tax reports link is displayed
    When I click on the previous submissions link
    And The first submission report status is <status>
    And The first submission report error heading is displayed <errorMsg>
    And The first submission report error message is displayed <msg2>
    And The first submission report download receipt button is displayed


    Examples:
      | username | password    | file                                            | msg1                | status   | errorMsg | msg2       |
      | "ba6950" | "zot003ret" | "/testData/SystemTestFiles/TestData-Excel.xlsx" | "Submission FAILED" | "FAILED" | "4000"   | "REJECTED" |

  Scenario Outline:As a BA user I should NOT be able to upload a non xml report with xml extension from upload council tax page
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
    And choose a file button is displayed
    When <file> is uploaded
    And Submit is clicked
    Then Confirmation page should be shown with <msg1>
    And Download receipt button is displayed
    And "We have received your file and have processed it unsuccessfully." message should be shown
    And Upload more Council Tax reports link is displayed
    When I click on the previous submissions link
    And The first submission report status is <status>
    And The first submission report error message is displayed <errorMsg>
    And The first submission report error message is displayed <msg2>
    And The first submission report download receipt button is displayed

    Examples:
      | username | password    | file                                            | msg1                | status   | errorMsg | msg2       |
      | "ba6950" | "zot003ret" | "/testData/SystemTestFiles/TestData-Image.xml"  | "Submission FAILED" | "FAILED" | "4000"   | "REJECTED" |
