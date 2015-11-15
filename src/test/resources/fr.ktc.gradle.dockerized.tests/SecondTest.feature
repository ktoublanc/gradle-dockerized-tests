Feature: A second feature

  Scenario: Run a tests on a docker container but in the second feature
    Given I create a HTTP request to check if my TomEE is up and running
    When I send the request
    Then I must have a 200 HTTP response