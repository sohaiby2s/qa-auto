Feature: Authentication

  Scenario: Verify that the valid token is successfully generating if valid credentials are provided

    When I pass the correct credentials to auth service
    Then I should get the status code 201
    And the JWT token is generated

  Scenario: Verify that the valid token is not generating if invalid credentials are provided

    When I pass the correct credentials to auth service to generate a new token
    Then I should get the status code 418
    And I should get the error message "Not In our system"

  Scenario Outline: Verify authentication failure message if the an invalid token is provided to the fetch the tasks
    When I pass the invalid token to fetch the tasks
    |token     |<token>   |
    Then I should get the status code 401

    Examples:
    |token                             |
    |eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1Ni|
    |""                                |

  Scenario: Verify that the previous token should be invalid if new token is generated
    Given I have valid authentication token to access api
    And I fetch the token to be used
    When I pass the correct credentials to auth service to generate a new token
    And I pass the previously generated token to fetch the tasks
    Then I should get the status code 401

  Scenario: Verify token should be invalidated if any modification is done in the generated token
    Given I have valid authentication token to access api
    When I modified the token by adding "test" in the end
    And I fetch all tasks by passing modified token
    Then I should get the status code 401