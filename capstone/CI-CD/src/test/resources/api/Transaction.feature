@transaksi
Feature: As user i want to make transactions

  @positive
  Scenario: As a user I want to see all transaction with authorization
    Given user user success login with valid account
    When user input token in authorization
    And user send request transaction
    Then user see status code 200
    And user see transaction

  @negative
  Scenario: As a user I want to see all transaction with not input token
    Given user user success login with valid account
    When user not input token in authorization
    And user send request transaction
    Then user see status code 401