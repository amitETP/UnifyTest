Feature: Successful product scan and billing for tender promotion

@discountpromotender
Scenario: Successful product scan and billing
Given the user is on the billing page for tender promotion 
When the user selects a salesperson for the tender promotion
And the user selects a customer for the tender promotion
And the user scans a product for the tender promotion
And the user clicks on checkout for the tender promotion
And the user selects the amount for the tender promotion
And the user clicks on save for the tender promotion
Then the bill is saved successfully for tender promotion applied
