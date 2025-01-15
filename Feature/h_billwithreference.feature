@billwithreference 
Feature: Bill With Reference - Sales Return Flow

 @billwithreference
    Scenario: Check bill with reference flow for sales return
    Given User is on billing screen  
    When user click on Sales Return
    Then user clicks on With Reference
    And user search with Invoice Number
    And user add return quantity and click on return 
    And user clicks on checkout
    And user clicks on submit 
    And user clicks on save 
    Then bill is saved successfully
     
     