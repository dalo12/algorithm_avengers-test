Feature: Login Functionality

  Scenario:  Successful login
    Given the user is on the login page
    When the user enters admin@iaw.com as email
    And the user enters admin123 as password
    Then the user is redirected to the dashboard page