package org.melek.api.test.steps;

import io.cucumber.java.en.Given;
import org.melek.api.test.util.JsonUtil;

public class RequestCreationSteps {

    Base base = Base.getInstance();

    @Given("request body is {string}")
    public void requestBodyIs(String jsonFile) throws Exception {
        base.requestSpecification.body(JsonUtil.getJsonFromFile(jsonFile));
    }

    @Given("set query parameter as name {string} value {string}")
    public void setQueryParameterAsNameValue(String parameterName, String parameterValue) {
        base.requestSpecification.params(parameterName, parameterValue);
    }

}
