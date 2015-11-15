Feature: My Simple Feature

  Scenario: Run a tests on a docker container
    Given I create a HTTP request to check if my TomEE is up and running
    When I send the request
    Then I must have a 200 HTTP response