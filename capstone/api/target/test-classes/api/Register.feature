@register
Feature: As admin i want to create account So that i can login and see home page

  @register-positive1
  Scenario: POST - As a admin I success to create account with valid data
    Given admin set endpoint for register
    When admin send create account with valid data
    Then admin see status code 200 after send register
    And admin see new detail account

  @register-negative
  Scenario: POST - As a admin I failed to create account with empty data
    Given admin set endpoint for register
    When admin send POST HTTP request with empty data register
    Then admin see status code 400 and fail to create account
    And admin get error message after regist

  @register-negative
  Scenario: POST - As a admin I failed to create account with empty email
    Given admin set endpoint for register
    When admin send POST HTTP request with empty email
    Then admin see status code 400 and fail to create account
    And admin get error message after regist

  @register-negative
  Scenario: POST - As a admin I failed to create account with not use @ in email
    Given admin set endpoint for register
    When admin send POST HTTP request with invalid email register
    Then admin see status code 400 and fail to create account
    And admin get error message after regist

  @register-negative
  Scenario: POST - As a admin I failed to create account with not use domain email
    Given admin set endpoint for register
    When admin send POST HTTP request with not use domain email
    Then admin see status code 400 and fail to create account
    And admin get error message after regist

  @register-negative
  Scenario: POST - As a admin I failed to create account with empty username
    Given admin set endpoint for register
    When admin send POST HTTP request with empty username
    Then admin see status code 400 and fail to create account
    And admin get error message after regist

  @register-negative
  Scenario: POST - As a admin I failed to create account with fill number on username field
    Given admin set endpoint for register
    When admin send POST HTTP request with fill number on username field
    Then admin see status code 200 after send register
    And admin see new detail account

  @register-negative
  Scenario: POST - As a admin I failed to create account with fill letter only on username field
    Given admin set endpoint for register
    When admin send POST HTTP request with fill letter on username field
    Then admin see status code 200 after send register
    And admin see new detail account

  @register-negative
  Scenario: POST - As a admin I failed to create account with empty password
    Given admin set endpoint for register
    When admin send POST HTTP request with empty password
    Then admin see status code 400 and fail to create account
    And admin get error message after regist

  @register-negative
  Scenario: POST - As a admin I failed to create account with invalid password
    Given admin set endpoint for register
    When admin send POST HTTP request with invalid password
    Then admin see status code 400 and fail to create account
    And admin get error message after regist

  @register-negative
  Scenario: POST - As a admin I failed to create account with fill password with number only
    Given admin set endpoint for register
    When admin send POST HTTP request with fill password with number
    Then admin see status code 200 after send register
    And admin see new detail account

  @register-negative
  Scenario: POST - As a admin I failed to create account with fill password with letter only
    Given admin set endpoint for register
    When admin send POST HTTP request with fill password with letter
    Then admin see status code 200 after send register
    And admin see new detail account

  @register-negative
  Scenario: POST - As a admin I failed to create account with fill password with combination char
    Given admin set endpoint for register
    When admin send POST HTTP request with fill password with combination char
    Then admin see status code 200 after send register
    And admin see new detail account