@productscanbill
Feature: ProductScan

@productscan
Scenario: Successful product scan and billing
    Given the user is on the product scan page
    When the user selects a salesperson
    And the user selects a customer
    Then the user scans a product
    And the user clicks on checkout
    And the user select the amount
    And the user clicks on save
    Then the bill is saved successfully

     
      