Feature: As user I want to create account So that i can login and see homepage

  @Scenario1
  Scenario: As user i have be able to success create account
    Given android user on landing screen login page
    When android user click to register
    And user input name
    And user input username
    And user input email
    And user input password
    And user iput confirm password
    And user click register button
    And user click confirm email
    Then user back to login page

  @fail1
  Scenario: As user i failed to create account with empty data
    Given android user on landing screen login page
    When android user click to register
    And user not input name
    And user not input username
    And user not input email
    And user not input password
    And user not input confirm password
    And user click register button
    Then user get error message

  @fail2
  Scenario: As user i failed to create account with registered email
    Given android user on landing screen login page
    When android user click to register
    And user input name
    And user input username
    And user input registered email
    And user input password
    And user input confirm password
    And user click register button
    Then user get error message "email is already in user"

  @fail3R
  Scenario: As user i failed to create account with registered username
    Given android user on landing screen login page
    When android user click to register
    And user input name
    And user input registered username
    And user input email
    And user input password
    And user input confirm password
    And user click register button
    Then user get error message "username is already taken"

  @fail4
  Scenario: As user i failed to create account with empty data
    Given android user on landing screen login page
    When android user click to register
    And user not input name
    And user not input username
    And user not input email
    And user not input password
    And user not input confirm password
    And user click register button
    Then user get error message

  @fail5
  Scenario: As user i failed to create account with empty data
    Given android user on landing screen login page
    When android user click to register
    And user not input name
    And user not input username
    And user not input email
    And user not input password
    And user not input confirm password
    And user click register button
    Then user get error message