@basicpromo
Feature: Basic Promotion 

@basicpromocheck
  Scenario: Check Basic Promotion is Successful 
    Given Basic Promotion link is available in menu 
    And user is on Basic Promotion from menu
    Then Basic Promotion list screen is displayed
    When user clicks on Basic by clicking on plus button
    Then user is navigated basic promotion creation page
    When user fills all the mandatory details in basic promotion
    And user clicks on save button in basic promotion
    Then basic promotion record will save successfully