@login
Feature: As a user I want to login in the app So that i can see homepage

  @positif
  Scenario: As a user i have be able to success login
    Given android user on landing screen
    When android user input valid email
    And android user input valid password
    And android user click login button
    Then android user see homepage

  @fail
  Scenario: As user i have failed to login
    Given android user on landing screen
    When android user input unregistered email
    And android user input password
    And android user tap login button
    Then android user see "email atau password tidak valid" message

  @fail2
  Scenario: As user i have failed to login with empty data
    Given android user on landing screen
    When android user not input email
    And android user not input password
    And android user tap login button
    Then android user see error message

  @fail3
  Scenario: As user i have failed to login
    Given android user on landing screen
    When android user input valid email
    And android user input invalid password
    And android user tap login button
    Then android user see "email atau password tidak valid" message

  @fail4
  Scenario: As user i have failed to login with empty email
    Given android user on landing screen
    When android user not input email
    And android user input valid password
    And android user tap login button
    Then android user see error message empty email

  @fail5
  Scenario: As user i have failed to login with empty password
    Given android user on landing screen
    When android user input valid email
    And android user not input password
    And android user tap login button
    Then android user see error message empty password