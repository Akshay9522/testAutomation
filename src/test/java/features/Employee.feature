Feature: Employee Module

Background: 
    Given user is on the OrangeHRM login page
    And the user enters valid username "Admin"
    And the user enters valid password "admin123"
    And the user clicks on the Login button

@sanity
Scenario: Add Employee to the System
    When User navigates to "PIM" module
    And Clicks on the "Add Employee" button
    And Enters "John" as First Name, "Doe" as Last Name
    And Clicks on Save
    Then Employee "John Doe" should be added successfully
    
  Scenario: Search for an Employee
    When User navigates to "PIM" module
    And Searches for Employee with name "John Doe"
    Then Employee details should be displayed

  Scenario: Delete an Employee
    When User navigates to "PIM" module
    And Searches for Employee with name "John Doe"
    And Clicks on the "Delete" button
    Then Employee should be removed from the system

  