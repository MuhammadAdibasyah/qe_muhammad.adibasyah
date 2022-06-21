@product
Feature: As user i want to see product and create new product

  Scenario: GET - As a user I want to get detail product
    Given user set endpoint for see product
    When user send request
    Then user see status code 200
    And user see product

  Scenario: GET - As a user I fail to get detail product
    Given user set wrong endpoint for see product
    When user send request
    Then user see status code 404
    And user get error message "not found"
    
  Scenario: POST - As a user I want to post product
    Given user set endpoint for add product
    When user send POST HTTP request with valid data product
    Then user see status code 200
    And user see new detail product