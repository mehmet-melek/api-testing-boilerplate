package org.melek.api.test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.melek.api.test.steps.Base;
import java.io.IOException;

public class Hooks {

    @After(order = 1)
    public void afterScenario(Scenario scenario) throws IOException {
        //Clean Request&Response
        Base.getInstance().response = null;
        Base.getInstance().requestSpecification = RestAssured.given();

    }
}
