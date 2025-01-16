Feature: Login Functionality

  Scenario:  Successful login
    Given the user is on the login page
    When the user enters "admin@iaw.com" as email and "admin123" as password
    When the user clicks the login button
    Then the user is redirected to the dashboard page

  Scenario:  Valid email and invalid password
    Given the user is on the login page
    When the user enters "admin@iaw.com" as email and "admin124" as password
    When the user clicks the login button
    Then the user remains in the login page

  Scenario:  Valid email and empty password
    Given the user is on the login page
    When the user enters "admin@iaw.com" as email and "" as password
    When the user clicks the login button
    Then the user remains in the login page

  Scenario:  Invalid email and valid password
    Given the user is on the login page
    When the user enters "admin@mail.com" as email and "admin123" as password
    When the user clicks the login button
    Then the user remains in the login page

  Scenario:  Invalid email and invalid password
    Given the user is on the login page
    When the user enters "admin@mail.com" as email and "admin124" as password
    When the user clicks the login button
    Then the user remains in the login page

  Scenario:  Invalid email and empty password
    Given the user is on the login page
    When the user enters "admin@mail.com" as email and "" as password
    When the user clicks the login button
    Then the user remains in the login page

  Scenario:  Empty email and valid password
    Given the user is on the login page
    When the user enters "" as email and "admin123" as password
    When the user clicks the login button
    Then the user remains in the login page

  Scenario:  Empty email and invalid password
    Given the user is on the login page
    When the user enters "" as email and "admin124" as password
    When the user clicks the login button
    Then the user remains in the login page

  Scenario:  Empty email and empty password
    Given the user is on the login page
    When the user enters "" as email and "" as password
    When the user clicks the login button
    Then the user remains in the login page