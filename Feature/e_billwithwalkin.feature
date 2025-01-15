@billwithwalkin  
Feature: Bill with Walk-in Customer

  @billwithwalkin  
  Scenario: Successful billing with walk-in customer  
    Given the user is on the billing page for a walk-in customer  
    When the user selects a salesperson for the walk-in customer  
    And the user scans a product for the walk-in customer  
    Then the user clicks on Checkout for the walk-in customer  
    And the user selects the amount for the walk-in customer  
    And the user clicks on Save for the walk-in customer  
    Then the bill is saved successfully for the walk-in customer

     
      