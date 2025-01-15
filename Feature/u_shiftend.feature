Feature: ShiftEnd

  Scenario: Check shift end is successful
    Given the user is on the billing screen for shift end
    And the user clicks on the three dots for shift end
    Then the user selects the shift end option
    When the user adds the amount for shift end
    And the user clicks on the shift end button
    Then the shift end is done successfully
   