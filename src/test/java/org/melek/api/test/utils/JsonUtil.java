package org.melek.api.test.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtil {

    public static JsonNode getJsonFromFile(String fileName) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/json_files/" + fileName);
        return new ObjectMapper().readTree(file);
    }

    public static String getJsonSchemaPath(String schemaFileName) {
        return "json-files/" + schemaFileName;
    }

}
