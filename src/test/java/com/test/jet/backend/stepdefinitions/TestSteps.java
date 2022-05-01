package com.test.jet.backend.stepdefinitions;


import com.test.jet.backend.context.AuthenticationContext;
import com.test.jet.backend.context.TaskContext;
import com.test.jet.backend.restclient.HttpRestClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;


public class TestSteps {

    AuthenticationContext authenticationContext = new AuthenticationContext();
    TaskContext taskContext = new TaskContext();


    @Given("I have valid authentication token to access api")
    public void thisIsTest(){
        authenticationContext.generateToken();
    }

    @When("I fetch all tasks")
    public void useTheToken(){
        taskContext.getTask();
    }

}
