@lift
Feature: Lift 

  @lift 
  Scenario: Lift 
    Given the user is on billing screen 
    When the user click on lift and drop
    And  the user is on lift and drop page
    Then the user enter cashier password
    And the user click on submit
    And  the lift and drop screen open
    And the user enter the amount in lift amount
    And the user select the reason 
    And the user click on save 
    Then lift was successful 