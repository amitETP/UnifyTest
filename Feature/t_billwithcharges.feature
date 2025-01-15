@billlingwithcharges
Feature: Billing with charges

  @billingwithcharges
  Scenario: Billing with charges
    Given the user is on the billing page for billing with charges
    When the user selects a salesperson for billing with charges
    And the user selects a customer for billing with charges
    And the user scans a product for billing with charges
    And the user clicks on checkout for billing with charges
    And the user selects the amount for billing with charges
    And the user clicks on save for billing with charges
    Then the billing process is completed successfully
