@register
Feature: As user i want to create account So that i can login and see home page

  @register-positive
  Scenario: POST - As a user I success to create account with valid data
    Given user set endpoint for register
    When user send create account with valid data
    Then user see status code 200 after send register
    And user see new detail account

  @register-negative
  Scenario: POST - As a user I failed to create account with empty data
    Given user set endpoint for register
    When user send POST HTTP request with empty data register
    Then user see status code 400 and fail to create account
    And user get error message
