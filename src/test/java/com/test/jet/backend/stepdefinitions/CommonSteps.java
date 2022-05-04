package com.test.jet.backend.stepdefinitions;

import com.test.jet.backend.restclient.HttpRestClient;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonSteps {

    @Autowired
    HttpRestClient httpRestClient;

    @Then("I should get the status code {int}")
    public void iShouldGetTheStatusCode(Integer status) {
        Assert.assertEquals(status, httpRestClient.getStatusCode());
    }
}
