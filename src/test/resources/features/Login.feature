Feature: Login
  As a user
  I want to login
  So that I can access my homepage

  Scenario: As a user I have to be able to login in saucedemo
    Given I am on the login page
    When I input valid username
    And I input valid password
    And click login button
    Then I go to home page

  Scenario: Failed login
    Given I am on the login page
    When I input protected username
    And I input valid password
    And click login button
    Then error message "Epic sadface: Sorry, this user has been locked out."