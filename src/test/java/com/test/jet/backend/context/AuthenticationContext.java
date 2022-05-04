package com.test.jet.backend.context;

import com.test.jet.backend.model.Login;
import com.test.jet.backend.restclient.HttpRestClient;
import com.test.jet.common.ConfigReader;
import io.restassured.http.Method;


public class AuthenticationContext extends CommonContext {


    private static final String AUTH_CREDENTIALS = "api/v1/auth/login";

    public static String token;

    HttpRestClient httpRestClient = new HttpRestClient();

    public void generateToken() {
        httpRestClient.initRestAPI();
        httpRestClient.setBody(getLoginData());
        httpRestClient.addHeader("Content-Type", "application/json");
        httpRestClient.sendHttpRequest(Method.POST, AUTH_CREDENTIALS);
        token = httpRestClient.getResponseBody().jsonPath().get("access_token");
    }

    private Login getLoginData() {
        Login login = new Login();
        login.setEmail(ConfigReader.getConfigReader().get("username").asText());
        login.setPassword(ConfigReader.getConfigReader().get("password").asText());
        return login;
    }
}
