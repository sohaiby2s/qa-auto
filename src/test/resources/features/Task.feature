Feature: Task

  Background:
    Given I have valid authentication token to access api

  Scenario: Validate that all task for the user is retrieving successfully
    When I fetch all tasks
    Then I should get the status code 200
    And I should receive all the tasks for the user

  Scenario Outline: Validate that the task should not be updated for the device id not found
    When I update the task <id> with the following parameters
      |title        |<title>          |
      |is_completed |<is_completed>   |
    Then I should get the status code 404
    Examples:
      |id    |title           |is_completed    |
      |1111  |hello test      |true            |


  Scenario Outline: Validate that the task is successfully updating
    When I update the task <id> with the following parameters
      |title        |<title>          |
      |is_completed |<is_completed>   |
    Then I should get the status code 200
    And the task should be updated
    |title       |<title>        |
    |is_completed|<is_completed> |
    Examples:
    |id    |title           |is_completed    |
    |1001  |hello test      |true            |
