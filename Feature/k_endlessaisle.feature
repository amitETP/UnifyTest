@endlessaisle  
Feature: Endless Aisle Order Process

  @endlessaisle  
  Scenario: Check endless aisle order process  
    Given the user is on the billing screen for Endless Aisle  
    When the user clicks on Endless Aisle  
    Then the user selects an address for Endless Aisle  
    And the user searches for the product for Endless Aisle  
    And the user clicks on Checkout for Endless Aisle  
    And the user clicks on Save for Endless Aisle  
    Then the user clicks on Submit for Endless Aisle  
    And the user selects Order Processing for Endless Aisle  
    And the user selects the checkbox for the order for Endless Aisle 
    And the user clicks on Ship and Invoice for Endless Aisle  
    Then the order should be shipped and invoiced successfully
     
     