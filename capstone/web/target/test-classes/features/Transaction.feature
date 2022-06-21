@transaction
Feature: As a user I want to pay for all items in the basket

  @positive
  Scenario: As user i have be able to success pay all items
    Given i am on the login page
    When i input valid email
    And i input valid password
    And i click login button
    And user click items
    And user click icon basket
    And user click pay button
    Then user success to pay all items

  @negative
  Scenario: As user i have fail to pay all items with not login
    Given i am on home page
    When user click items
    And user click icon basket
    And user click pay button
    Then Then user is moved to the login page
