Feature: Testing different request on the virgin games application

  Scenario: Verify response contains correct currencies respectively
    When User sends a GET request with currency as GBP
    Then User must get back a valid status code 200
    And User must get back response with currency as GBP