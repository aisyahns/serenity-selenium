@Login
Feature: Login
  As a user
  I want to login
  So that I can access my homepage

  Background:
    Given I am on the login page

  @DDT
  Scenario Outline: Login scenario
    When I input "<username>" username
    And I input "<password>" password
    And click login button
    Then I get the "<result>"
    Examples:
    |username|password|result|
    |standard_user|secret_sauce|home page|
    |locked_out_user|secret_sauce|Epic sadface: Sorry, this user has been locked out.|
    |               |            |Epic sadface: Username is required                 |
    |               |secret_sauce|Epic sadface: Username is required                 |
    |standard_user  |            |Epic sadface: Password is required                 |
    |standard_user  |password123 |Epic sadface: Username and password do not match any user in this service|

  @Normal
  Scenario: As a user I have to be able to login in saucedemo
    When I input valid username
    And I input valid password
    And click login button
    Then I go to home page

    @Failed
  Scenario: Failed login
    When I input protected username
    And I input valid password
    And click login button
    Then error message "Epic sadface: Sorry, this user has been locked out."


  @ToolsQA
  Scenario Outline: Login scenario
    Given I am on the login page
    When I input "<username>" username
    And I input "<password>" password
    And click login button
    Then I get the "<result>"
    Examples:
      |username|password|result|
      |||icon warning|
      ||Password1234|icon warning|
      |aisyah22||icon warning|
      |aisyah22|Password1234|Invalid username or wrong password|
      |aisyahns22|Password1234!|page profile|