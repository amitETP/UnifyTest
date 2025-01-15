Feature: Apply and Save Bill Promotion

@discountpromobill
Scenario: User applies a discount promotion and saves the bill

Given the user is on the billing page
When the user selects a salesperson for the bill promotion
And the user selects a customer for the bill promotion
And the user scans a product for the bill promotion
And the user clicks on checkout for the bill promotion
And the user selects the amount for the bill promotion
And the user clicks on save for the bill promotion
Then the bill is saved successfully for discount promotion applied

     
      