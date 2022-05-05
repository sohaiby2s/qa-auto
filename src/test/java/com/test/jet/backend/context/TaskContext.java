package com.test.jet.backend.context;


import com.test.jet.backend.model.Data;
import com.test.jet.backend.model.DataTask;
import com.test.jet.backend.model.Payload;
import com.test.jet.backend.restclient.HttpRestClient;
import io.restassured.http.Method;

import java.util.Map;


public class TaskContext extends CommonContext {

    private static final String GET_TASK_ENDPOINT = "api/v1/tasks";
    private final HttpRestClient httpRestClient = new HttpRestClient();


    public void getTask(String token) {
        httpRestClient.initRestAPI();
        httpRestClient.addToken(token);
        httpRestClient.sendHttpRequest(Method.GET, GET_TASK_ENDPOINT);

    }

    public int getTasksLength() {
        return parseJsonResponseData().getData().size();
    }

    public void updateTask(int taskId, Map<String, String> data) {
        httpRestClient.initRestAPI();
        httpRestClient.addToken(AuthenticationContext.token);
        httpRestClient.setBody(generatePayload(data));
        httpRestClient.sendHttpRequest(Method.PUT, GET_TASK_ENDPOINT + "/" + taskId);
    }

    private Payload generatePayload(Map<String, String> data) {
        Payload payload = new Payload();
        payload.setTitle(data.get("title"));
        payload.set_completed(Boolean.parseBoolean(data.get("is_completed")));
        return payload;
    }

    public DataTask parseJsonResponseTask() {
        return parseJsonResponseData(httpRestClient.getResponseBody(), DataTask.class);
    }

    public Data parseJsonResponseData() {
        return parseJsonResponseData(httpRestClient.getResponseBody(), Data.class);
    }
}
