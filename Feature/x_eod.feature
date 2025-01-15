@eod
Feature: Bod Save

 @eodsave
    Scenario: Check eod save is successful
    Given Eod link is displayed in menu 
    And user is on Eod link from menu
    Then user select store from dropdown for eod
    When user clicks on Save for eod
    Then eod is done successfully
     
      