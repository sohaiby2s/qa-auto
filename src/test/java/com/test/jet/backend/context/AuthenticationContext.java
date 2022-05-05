package com.test.jet.backend.context;

import com.test.jet.backend.model.Error;
import com.test.jet.backend.model.Login;
import com.test.jet.backend.restclient.HttpRestClient;
import com.test.jet.common.ConfigReader;
import io.restassured.http.Method;


public class AuthenticationContext extends CommonContext {


    private static final String AUTH_CREDENTIALS = "api/v1/auth/login";

    public static String token;
    public static String originalToken;

    HttpRestClient httpRestClient = new HttpRestClient();

    public void generateToken(Login login) {
        httpRestClient.initRestAPI();
        httpRestClient.setBody(login);
        httpRestClient.addHeader("Content-Type", "application/json");
        httpRestClient.sendHttpRequest(Method.POST, AUTH_CREDENTIALS);
        token = httpRestClient.getResponseBody().jsonPath().get("access_token");
    }

    public Login getLoginData() {
        Login login = new Login();
        login.setEmail(ConfigReader.getConfigReader().get("username").asText());
        login.setPassword(ConfigReader.getConfigReader().get("password").asText());
        return login;
    }

    public Login getInvalidLoginData(){
        Login login = new Login();
        login.setEmail("abc@test.com");
        login.setPassword("1234567");
        return login;
    }

    public String getAuthErrorMessage(){
        Error error = parseJsonResponseData(httpRestClient.getResponseBody(), Error.class);
        return error.getErrors().getEmail();
    }

    public void setOriginalToken(){
        originalToken = AuthenticationContext.token;
    }

    public void modifyExistingToken(String text){
        token = token+text;
    }
}
