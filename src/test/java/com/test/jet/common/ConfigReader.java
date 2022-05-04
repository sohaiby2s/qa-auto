package com.test.jet.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;


/**
 * ConfigParser parse the configuration file and pass configuration properties to required functionalities
 */
public class ConfigReader {

    public static final String CONFIG_PATH = "src/test/resources/configurations/configurations.json";
    private static JsonNode jsonNode;
    public static final String API_URL = getConfigReader().get("url").asText();

    private ConfigReader() {
    }

    public static JsonNode getConfigReader() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonNode = objectMapper.readTree(new File(CONFIG_PATH));
            jsonNode = jsonNode.get(getEnv());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    /**
     * This methods gets the environment value from the environmental variables which defaults to dev1
     */
    public static String getEnv() {
        return StringUtils.isEmpty(System.getProperty("env")) ? "dev1" : System.getProperty("env");
    }

}
