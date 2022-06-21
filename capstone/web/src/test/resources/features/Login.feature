@login
Feature: As user I want to login So that i can see home page

  Background:
    Given i am on the login page

  @positive
  Scenario: As user i have be able to success login
    When i input valid email
    And i input valid password
    And i click login button
    Then i success login

  @negative
  Scenario: As user i have failed to login with invalid password
    When i input valid email
    And i input invalid password
    And i click login button
    Then i failed to login and get error message "email or password invalid"

  @negative
  Scenario: As user i have failed to login with invalid email
    When i input invalid email
    And i input valid password
    And i click login button
    Then i fail to login and get error message "record not found"

  @negative
  Scenario: As user i have failed to login with not input data
    When i not input username and password
    And i click login button
    Then i get error message "email is required"