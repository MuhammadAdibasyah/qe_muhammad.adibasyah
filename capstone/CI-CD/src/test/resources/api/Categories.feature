@categories
Feature: As user i want to see categories and add new categories

  Scenario: GET - As a user I want to get all categories
    Given user set endpoint for see categories
    When user send request categories
    Then user see status code 200
    And user see all categories

  Scenario: POST - As a user I want to create new categories with valid data
    Given Given user set endpoint for add categories
    When user send POST HTTP request with valid data categories
    Then user see status code 200
    And user see new detail categories