package com.test.jet.backend.context;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.jet.backend.model.Data;
import io.restassured.response.ResponseBody;

import java.util.List;

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
