@books
Feature: As a user I want to check book in bookstore So that i visit to bookstore

  Scenario: GET - As admin I have be able to see existing book
    Given I set GET api endpoints
    When  I send GET HTTP request
    Then I receive valid HTTP response code 200
    And I receive valid data for detail book

#  @negative
#  Scenario: GET Book - As admin i failed to see existing book with input data
#    Given I set GET Book api endpoints
#    When  I send GET Book HTTP request
#    Then I receive valid HTTP response code 400
#    And I receive error message
