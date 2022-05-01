package com.test.jet.backend.restclient;


import com.test.jet.common.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;


/**
 * HttpRestClient is use to call Rest Api and perform all the functions
 * specifically relating to the API requests and responses
 */


@Component
public class HttpRestClient {

    private RequestSpecification requestSpecification;
    private ResponseBody responseBody;
    public static Integer statusCode;
    private Response response;

    public HttpRestClient() {
        RestAssured.baseURI = ConfigReader.API_URL;
    }

    public void initRestAPI() {
        requestSpecification = RestAssured.given();
    }

    /**
     * This method calls the Rest API
     */
    public void sendHttpRequest(Method method, String endpoint) {
        response = requestSpecification.request(method, endpoint);
        setResponseBody(response.getBody());
        statusCode = response.getStatusCode();
    }

    public void setBody(Object body) {
        requestSpecification.body(body);
    }

    public void addHeader(String header, String value) {
        requestSpecification.header(header, value);
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    private void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public void addToken(String oauthToken){
        requestSpecification.auth().oauth2(oauthToken);
    }

    public Integer getStatusCode(){
        return statusCode;
    }

}
