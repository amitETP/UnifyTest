@billcancellation  
Feature: Bill Cancellation

  @billcancellation  
  Scenario: Check bill cancellation process  
    Given the user is on the billing screen for bill cancellation  
    When the user clicks on Sales Return for bill cancellation  
    Then the user clicks on Bill Cancellation  
    And the user searches for the invoice number for bill cancellation  
    And the user clicks on Checkout for bill cancellation  
    And the user clicks on Submit for bill cancellation  
    And the user clicks on Save for bill cancellation  
    Then the bill cancellation should be successful
     
     