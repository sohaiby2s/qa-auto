$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Task.feature");
formatter.feature({
  "name": "Task",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I have valid authentication token to access api",
  "keyword": "Given "
});
formatter.match({
  "location": "TestSteps.thisIsTest()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate that all task for the user is retrieving successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I fetch all tasks",
  "keyword": "When "
});
formatter.match({
  "location": "TestSteps.useTheToken()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get the status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.iShouldGetTheStatusCode(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should receive all the tasks for the user",
  "keyword": "And "
});
formatter.match({
  "location": "TestSteps.iShouldReceiveAllTheTaskNumbers()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Validate that the task should not be updated for the device id not found",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I update the task \u003cid\u003e with the following parameters",
  "keyword": "When ",
  "rows": [
    {
      "cells": [
        "title",
        "\u003ctitle\u003e"
      ]
    },
    {
      "cells": [
        "is_completed",
        "\u003cis_completed\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "I should get the status code 404",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "id",
        "title",
        "is_completed"
      ]
    },
    {
      "cells": [
        "1111",
        "hello test",
        "true"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I have valid authentication token to access api",
  "keyword": "Given "
});
formatter.match({
  "location": "TestSteps.thisIsTest()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate that the task should not be updated for the device id not found",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I update the task 1111 with the following parameters",
  "rows": [
    {
      "cells": [
        "title",
        "hello test"
      ]
    },
    {
      "cells": [
        "is_completed",
        "true"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TestSteps.iUpdateTheTaskWithTheFollowingParameters(int,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get the status code 404",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.iShouldGetTheStatusCode(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Validate that the task is successfully updating",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I update the task \u003cid\u003e with the following parameters",
  "keyword": "When ",
  "rows": [
    {
      "cells": [
        "title",
        "\u003ctitle\u003e"
      ]
    },
    {
      "cells": [
        "is_completed",
        "\u003cis_completed\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "I should get the status code 200",
  "keyword": "Then "
});
formatter.step({
  "name": "the task should be updated",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "title",
        "\u003ctitle\u003e"
      ]
    },
    {
      "cells": [
        "is_completed",
        "\u003cis_completed\u003e"
      ]
    }
  ]
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "id",
        "title",
        "is_completed"
      ]
    },
    {
      "cells": [
        "1001",
        "hello test",
        "true"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I have valid authentication token to access api",
  "keyword": "Given "
});
formatter.match({
  "location": "TestSteps.thisIsTest()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate that the task is successfully updating",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I update the task 1001 with the following parameters",
  "rows": [
    {
      "cells": [
        "title",
        "hello test"
      ]
    },
    {
      "cells": [
        "is_completed",
        "true"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TestSteps.iUpdateTheTaskWithTheFollowingParameters(int,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get the status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.iShouldGetTheStatusCode(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the task should be updated",
  "rows": [
    {
      "cells": [
        "title",
        "hello test"
      ]
    },
    {
      "cells": [
        "is_completed",
        "true"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "TestSteps.theTaskShouldBeUpdated(String,String\u003e)"
});
formatter.result({
  "error_message": "org.assertj.core.api.SoftAssertionError: \nThe following 2 assertions failed:\n1) [Title is not updated] expected:\u003c\"[Culpa nulla suscipit sequi est beatae omnis ipsa repellat.]\"\u003e but was:\u003c\"[hello test]\"\u003e\n2) [Is completed not updated] expected:\u003c[false]\u003e but was:\u003c[\"true\"]\u003e\n\n\tat org.assertj.core.error.AssertionErrorCreator.multipleSoftAssertionsError(AssertionErrorCreator.java:100)\n\tat org.assertj.core.api.AbstractSoftAssertions.assertAll(AbstractSoftAssertions.java:37)\n\tat org.assertj.core.api.AbstractSoftAssertions.assertAll(AbstractSoftAssertions.java:42)\n\tat com.test.jet.backend.stepdefinitions.TestSteps.theTaskShouldBeUpdated(TestSteps.java:58)\n\tat ✽.the task should be updated(file:src/test/resources/features/Task.feature:27)\n",
  "status": "failed"
});
});