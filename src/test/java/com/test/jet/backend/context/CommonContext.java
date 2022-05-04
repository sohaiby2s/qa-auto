package com.test.jet.backend.context;

import io.restassured.response.ResponseBody;


/**
 * The CommonContext is an abstract class holds the common functionality
 * that has been used by other context classes
 */

public abstract class CommonContext {
    /**
     * This is generic method of parsing JSON string into JAVA object
     */

    protected <T> T parseJsonResponseData(ResponseBody responseBody, Class<T> className) {
        return responseBody.as(className);
    }

}
