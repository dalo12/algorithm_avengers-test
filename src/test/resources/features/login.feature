Feature: Login Functionality

  Scenario:  Successful login
    Given the user is on the login page
    When the user enters "admin@iaw.com" as email and "admin123" as password
    When the user clicks the login button
    Then the user is redirected to the dashboard page