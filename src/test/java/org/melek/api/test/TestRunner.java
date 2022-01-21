package org.melek.api.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.melek.api.test.configurations.RunnerConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(publish = false,
        features = "src/test/resources/features",
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner {

    @BeforeClass()
    public static void beforeAllTest() {
        RunnerConfiguration.configureSUT();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Execution Report:\n" + System.getProperty("report.url"));
    }
}
