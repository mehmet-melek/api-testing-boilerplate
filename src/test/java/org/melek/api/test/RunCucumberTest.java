package org.melek.api.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.melek.api.test.configuration.RunnerConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(publish = false,
        features = "src/test/resources/features",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RunCucumberTest {
    @BeforeClass()
    public static void doSomething() {
        RunnerConfiguration.configureBaseURI();
    }

    @AfterClass
    public static void teardown() {
        System.out.println("Execution Report:\n" + System.getProperty("report.url"));
    }
}