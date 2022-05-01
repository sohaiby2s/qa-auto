package com.test.jet.backend.context;


import com.test.jet.backend.restclient.HttpRestClient;
import io.restassured.http.Method;


public class TaskContext extends CommonContext{

    private static final String GET_TASK_ENDPOINT = "api/v1/tasks";
    private final HttpRestClient httpRestClient = new HttpRestClient();


    public void getTask(){
        httpRestClient.initRestAPI();
        httpRestClient.addToken(AuthenticationContext.token);
        httpRestClient.sendHttpRequest(Method.GET,GET_TASK_ENDPOINT);

    }

}
