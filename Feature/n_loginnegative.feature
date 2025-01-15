@login
Feature: Test Login functionality
@loginunify
  Scenario: Check login fails with empty username  						//username is empty
    Given browser is open for unify
    And user is on login page for unify
    When user leaves username field empty
    And user enters a valid password
    And user clicks on login for unify
    Then an error message is displayed indicating that the username is required
    And user remains on the login page

  Scenario: Check login fails with empty password  						//password is empty
    Given browser is open for unify
    And user is on login page for unify
    When user enters a valid username
    And user leaves the password field empty
    And user clicks on login for unify
    Then an error message is displayed indicating that the password is required
    And user remains on the login page

  Scenario: Check login fails with both fields empty   					//username and password both are empty 
    Given browser is open for unify
    And user is on login page
    When user leaves both username and password fields empty
    And user clicks on login for unify
    Then an error message is displayed indicating that both fields are required
    And user remains on the login page
    

 Scenario: Check login fails with account locked              //account is locked 
    Given browser is open for unify
    And user is on login page for unify
    When user enters a valid username
    And user enters an incorrect password multiple times
    Then an error message is displayed indicating that the account is locked
    And user remains on the login page

    