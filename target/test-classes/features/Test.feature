Feature: Test

  Scenario: Test scenario
    Given I have valid authentication token to access api
    When I fetch all tasks
    Then I should get the status code 200