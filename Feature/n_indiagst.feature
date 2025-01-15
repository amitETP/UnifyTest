@indigst  
Feature: Bill Save - India GST

  @indiagst  
  Scenario: Check India GST Taxes  
    Given the user is on the product scan page for India GST  
    When the user selects a salesperson for India GST  
    And the user selects a customer for India GST  
    Then the user scans a product for India GST  
    And the user clicks on "Checkout" for India GST  
    And the user selects the amount for India GST  
    And the user clicks on "Save" for India GST  
    Then the bill is saved successfully with India GST applied
  