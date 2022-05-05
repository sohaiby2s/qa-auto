package com.test.jet.backend.stepdefinitions;

import com.test.jet.backend.context.AuthenticationContext;
import com.test.jet.backend.model.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class AuthenticationSteps {

    AuthenticationContext authenticationContext = new AuthenticationContext();

    @When("I pass the correct credentials to auth service")
    @Given("I have valid authentication token to access api")
    public void iHaveValidAuthenticationTokenToAccessApi() {
        Login loginData = authenticationContext.getLoginData();
        authenticationContext.generateToken(loginData);
    }

    @Then("the JWT token is generated")
    public void theJWTTokenIsGenerated(){
        Assertions.assertThat(AuthenticationContext.token).as("Token is not generated").isNotEmpty();
    }

    @When("I pass the correct credentials to auth service to generate a new token")
    public void iPassTheInvalidCredentialsToAuthService(){
        Login invalidLoginData = authenticationContext.getInvalidLoginData();
        authenticationContext.generateToken(invalidLoginData);
    }

    @Then("I should get the error message {string}")
    public void iShouldGetTheErrorMessage(String errorMessage){
        String actualError = authenticationContext.getAuthErrorMessage();
        Assertions.assertThat(actualError)
                .as("Error message is not correct").isEqualTo(errorMessage);
    }

    @When("I fetch the token to be used")
    public void iFetchTheTokenToBeUsed(){
        authenticationContext.setOriginalToken();
    }

    @When("I modified the token by adding {string} in the end")
    public void iModifiedTheTokenByAddingInTheEnd(String text){
        authenticationContext.modifyExistingToken(text);
    }

}
