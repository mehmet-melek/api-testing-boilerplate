package org.melek.api.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = false,
        features = "src/test/resources/features",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RunTest {
    @BeforeClass()
    public static void BeforeAllTest() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @AfterClass
    public static void teardown() {
        System.out.println("Execution Report:\n" + System.getProperty("report.url"));
    }
}
