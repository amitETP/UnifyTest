@onlineorder  
Feature: Online Order Process  

  @onlineorder  
  Scenario: Check online order process  
    Given the user is on the order processing page  
    When the user clicks on "Allocation"  
    Then the user selects "Accept Order"  
    And the user clicks on "Pack Order"  
    And the user clicks on "Generate Shipping Label"  
    And the user selects a payment option  
    And the user clicks on "Submit"  
    Then the order is placed successfully
     