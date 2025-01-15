@dualscreen
Feature: Dual Screen 

@dualscreen 
  Scenario: User selects a salesperson on the primary screen
    Given the user is on the primary screen
    When the user selects the salesperson dropdown
    Then the selected salesperson should be displayed on the primary screen
    And the secondary screen should reflect same as the selected salesperson
    
  
  
    