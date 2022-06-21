@product
Feature: As a user I want to buy items in the home page

  Scenario: As user i have be able to buy items
    Given user on the home page
    When user click items
    Then user success to buy items

  Scenario: As user i want to verify quantity working or not
    Given user on the home page
    When user click items
    And user to basket page
    And user increases the number of items
    Then user success to increases items