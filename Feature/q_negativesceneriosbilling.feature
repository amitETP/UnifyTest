@negativesceneriobilling
Feature: Negative Scenerio Billing

 
 #Scenario: User tries to search for a product without selecting a salesperson
    #Given the user is on the product search page
    #And no salesperson is selected
    #When the user enters a product name 
    #Then the system should display an error message for salesperson not displayed


  #Scenario: User tries to search for a product without selecting a customer
    #Given the user is on the product search page
    #And no customer is selected
    #When the user enters a product name in the search bar
    #Then the system should display an error message for customer not selected
    
 
 #Scenario: User searches for a product that is not found
    #Given the user is on the product search page
    #When the user enters a invalid product name 
    #Then the system should display a message for product not found
  #
    #
#
 #@negativesceneriobilling 
  #Scenario: User searches for a customer that is not found
    #Given the user is on the product search page
    #When the user enters a customer name in the search bar
    #Then the system should display a message for customer not found
    
    #
    #
 #Scenario: User tries to checkout without selecting a payment mode
    #Given the user is on the product search page
    #When the user scan a product 
    #And the user is on the checkout page
    #And no payment mode is selected
    #When the user clicks the checkout button
    #Then the system should display an error message for payment not selected
   #
    #
    #
#Scenario: User attempts to set the sales price to zero
    #Given the user is on the product search page
    #When the user scan a product 
    #When the user changes the sales price to zero 
    #Then the system should display an error message for zero salesprice
    
    
  #Scenario: User selects the same salesperson for primary and secondary roles
    #Given the user is on the product search page
    #When the user selects primary salesperson
    #And the user selects  secondary salesperson
    #Then the system should display a message for same salesperson selected
    
    
 #Scenario: User applies an invalid discount code
    #Given the user has items in their cart totaling "$200"
    #And the user is on the checkout page
    #When the user enters a discount code "INVALIDCODE"
    #And clicks the "Apply" button
    #Then the system should display an error message "Discount code is not valid"
    #And the total amount should remain "$200"
    
    
 #Scenario: User scans a product with an unconfigured HSN code
    #Given the user is on the product search page
    #When the user scans the product
    #Then the system should display an error message for HSN code not configured
    
 
#Scenario: User scans a product with an unconfigured charge model
    #Given the user is on the product search page
    #When the user scans the product
    #Then the system should display an error message for charge model not configured

    
    
 #Scenario: User tries to checkout with charges more than sales price
    #Given the user is on the product search page
    #And the user edit the charges
    #When the user clicks the checkout button
    #Then the system should display an error message for charges
    #And the user should remain on the checkout page


     