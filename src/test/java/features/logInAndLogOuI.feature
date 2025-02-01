Feature: Login and Logout Functionality

Background: 
    Given user is on the OrangeHRM login page 

  Scenario: Verify Successful Login
    When the user enters valid username "Admin"
    And the user enters valid password "admin123"
    And the user clicks on the Login button
    Then the user should be redirected to the Dashboard page

  Scenario: Verify Login with Invalid Credentials
    When the user enters invalid username "WrongUser"
    And the user enters invalid password "WrongPass123"
    And the user clicks on the Login button
    Then the user should see an error message "Invalid credentials"

  Scenario: Verify Login with Empty Fields
    When the user leaves the username and password fields empty
    And the user clicks on the Login button
    Then the user should see a validation message "Required"

  Scenario: Verify Logout Functionality
    When the user enters valid username "Admin"
    And the user enters valid password "admin123"
    And the user clicks on the Login button
    When the user clicks on the profile icon
    And the user clicks on "Logout"
    Then the user should be redirected back to the login page
