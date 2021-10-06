package org.melek.api.test.configuration;

import io.restassured.RestAssured;

public class RunnerConfiguration {

    public static void configureBaseURI() {
        if (System.getProperty("app.host.name") != null) {
            RestAssured.baseURI = System.getProperty("app.host.name").replace("https", "http");
        } else {
            switch (System.getProperty("env.code") != null ? System.getProperty("env.code") : "LOCAL") {
                case "TST":
                    RestAssured.baseURI = "test-link";
                    break;
                case "UAT":
                    RestAssured.baseURI = "uat-link";
                    break;
                case "DEV":
                    RestAssured.baseURI = "dev-link";
                    break;
                case "LOCAL":
                    RestAssured.baseURI = "https://reqres.in";
                default:
                    //do something
                    System.out.println("Define new ENV");
            }
        }
    }
}

