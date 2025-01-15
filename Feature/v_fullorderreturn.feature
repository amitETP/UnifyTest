Feature: Full order return

  Scenario: Customer initiates a full return for an order
    Given the customer has placed an order with order number
    When the customer navigates to the order processing page
    And the customer selects the Return Order option
    And the customer selects Full Return for the entire order
    And the customer submits the return request
    Then the return request should be successfully processed
    And the customer should receive a confirmation message with return details
    And the order status should be updated to Returned