@bod
Feature: Bod Save

 @bodsave
    Scenario: Check bod save is successful
    Given Bod link is displayed in menu 
    And user is on bod link from menu
    Then user select store from dropdown
    When user clicks on Save 
    Then bod is done successfully
     
      