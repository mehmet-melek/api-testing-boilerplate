package org.melek.api.test.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
    public Response response;
    public RequestSpecification requestSpecification = RestAssured.given();

    // static değişkenimiz singleton class’ımızın instance’ı
    private static Base instance = null;


    // synchronized anahtarını ekleyerek her thread’in bir sonrakini beklemesini sağladık , aynı anda 2 thread bu methodu kullanamaz.
    private synchronized static void createInstance() {
        if (instance == null)
            instance = new Base();
    }

    public static Base getInstance() {
        if (instance == null)
            createInstance();
        return instance;
    }
}
