package org.melek.api.test.steps;

import io.cucumber.java.en.When;

public class HttpRequestSteps {

    Base base = Base.getInstance();

    @When("get {string}")
    public void get(String path) {
        base.response = base.requestSpecification.when().get(path);
    }

    @When("post {string}")
    public void post(String path) {
        base.response = base.requestSpecification.post(path);
    }

}
