package org.melek.api.test.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonUtil {

    public static JsonNode getJsonFromFile(String fileName) throws Exception {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/json_files/" + fileName);
        return new ObjectMapper().readTree(file);
    }

    public static String getSchemaPath(String schemaFileName) {
        return "json_files/" + schemaFileName;
    }
}
