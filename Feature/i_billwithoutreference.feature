@billwithoutreference  
Feature: Bill Without Reference - Sales Return Flow

 @billwithoutreference
    Scenario: Check bill without reference for sales return  
    Given the user is on the billing screen for Sales Return
    When the user clicks on Sales Return for without reference
    Then the user clicks on Without Reference 
    And the user searches for the product   
    And the user clicks on Checkout for without reference
    And the user clicks on Submit for without reference
    And the user clicks on save for without reference
    Then the user bill without reference for sales return is successful  
     
     