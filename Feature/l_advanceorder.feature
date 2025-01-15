@advanceorder  
Feature: Advance Order Process

  @advanceorder  
  Scenario: Check advance order process  
    Given the user is on the billing screen  
    When the user clicks on Order  
    Then the user selects an address for the advance order  
    And the user searches for the product for the advance order  
    And the user clicks on Checkout for the advance order  
    And the user clicks on Save for the advance order  
    Then the user clicks on Submit for the advance order  
    And the user selects Order Processing
    And the user selects the checkbox for the order  
    And the user clicks on Ship and Invoice
    Then the order is shipped and invoice successfully
     
     