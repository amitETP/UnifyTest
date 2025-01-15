@billwithreference 
Feature: Bill With Reference - Order Return Flow

  @billwithreference
  Scenario: Check bill with reference for order return
    Given User is on billing screen for partial order return
    When user clicks on Sales Return for partial order return
    Then user clicks on With Reference for partial order return
    And user searches with Invoice Number for partial order return
    And user adds return quantity for order return
    And user clicks on checkout for order return
    And user clicks on submit for order return
    And user clicks on save for order return
    Then bill is saved successfully for order return
     