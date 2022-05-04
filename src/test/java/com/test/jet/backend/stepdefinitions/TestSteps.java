package com.test.jet.backend.stepdefinitions;


import com.test.jet.backend.context.AuthenticationContext;
import com.test.jet.backend.context.TaskContext;
import com.test.jet.backend.model.DataTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.Map;


public class TestSteps {

    AuthenticationContext authenticationContext = new AuthenticationContext();
    TaskContext taskContext = new TaskContext();
    SoftAssertions softAssertions = new SoftAssertions();


    @Given("I have valid authentication token to access api")
    public void thisIsTest() {
        authenticationContext.generateToken();
    }

    @When("I fetch all tasks")
    public void useTheToken() {
        taskContext.getTask();
    }

    @And("I should receive all the tasks for the user")
    public void iShouldReceiveAllTheTaskNumbers() {
        int taskLength = taskContext.getTasksLength();
        Assertions.assertThat(10).as("task length is not correct").isEqualTo(taskLength);
    }

    @When("I update the task {int} with the following parameters")
    public void iUpdateTheTaskWithTheFollowingParameters(int taskId, Map<String, String> data) {
        taskContext.updateTask(taskId, data);
    }

    @Then("the task should be updated")
    public void theTaskShouldBeUpdated(Map<String, String> data) {
        DataTask dataTask = taskContext.parseJsonResponseTask();

        softAssertions.assertThat(data.get("title")).as("Title is not updated")
                .isEqualTo(dataTask.getData().getTitle());
        softAssertions.assertThat(data.get("is_completed")).as("Is completed not updated")
                .isEqualTo(dataTask.getData().is_completed());
        softAssertions.assertAll();
    }
}
