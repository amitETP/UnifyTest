@shiftbegin
Feature: ShiftBegin 

 @shiftbegin 
    Scenario: Check shift begin  is successful
    Given POS link is displayed in menu 
    And user is on POS link from menu
    Then user select company 
    When user select store
    And user select counter 
    Then shiftbegin is done successfully
     
      