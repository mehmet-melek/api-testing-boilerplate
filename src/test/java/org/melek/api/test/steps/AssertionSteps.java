package org.melek.api.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.melek.api.test.utils.JsonUtil;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class AssertionSteps {

    Base base = Base.getInstance();


    @And("current page should be {int}")
    public void currentPageShouldBe(int currentPage) {
        base.response.then().assertThat()
                .body("page", is(currentPage));
    }

    @Then("per_page value should be {int}")
    public void per_pageValueShouldBe(int itemPerPage) {
        base.response.then().assertThat()
                .body("per_page", is(itemPerPage));
    }

    @And("response schema must be same as {string}")
    public void responseSchemaMustBeSameAs(String responseSchemaFile) {
        base.response.then().assertThat()
                .body(matchesJsonSchemaInClasspath(JsonUtil.getJsonSchemaPath(responseSchemaFile)));
    }

    @And("data list must have {int} element")
    public void dataListMustHaveElement(int dataSize) {
        List<String> list = base.response.jsonPath().get("data");
        Assert.assertEquals(dataSize, list.size());
    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer statusCode) {
        base.response.then().assertThat().statusCode(statusCode);
    }

}
