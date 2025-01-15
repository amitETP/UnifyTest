@drop
Feature: Drop

  @drop 
  Scenario: Drop 
    Given the user is on billing screen for drop
    When the user click on lift and drop button
    And  the user is on drop page
    Then the user enter cashier password for drop
    And the user click on submit for drop
    And  the drop screen open
    And the user enter the amount in drop amount
    And the user select the reason for drop
    And the user click on save for drop
    Then drop was successful 