package org.melek.api.test;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.melek.api.test.steps.Base;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hooks {

    @After(order = 1)
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] data = Files.readAllBytes(Path.of("src/test/resources/img/dummy.jpg"));
            scenario.attach(data, "image/png", "My screenshot");
            scenario.log("error log here");
        }

        //Clean Request&Response
        Base.getInstance().response = null;
        Base.getInstance().requestSpecification = RestAssured.given();

    }
}
