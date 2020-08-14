package Steps;

import Utilities.RestAssuredExtension;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;


public class GETEmployeesSteps {

    public static ResponseOptions<Response> response;

    @Given("Server is up and running")
    public void serverIsUpAndRunning() {
        System.out.println("Server is up");
    }

    @When("I perform GET request at {string}")
    public void iPerformGETRequestAt(String url) {

        response= RestAssuredExtension.GETRequest(url);
    }

    @Then("I validate that status code is {int}")
    public void iValidateThatStatusCodeIs(int statusCode) {
        assertThat(response.getStatusCode(),equalTo(statusCode));
    }

    @And("I validate that employees first name is {string}")
    public void iValidateThatEmployeesFirstNameIs(String firstName) {
        assertThat(response.getBody().jsonPath().get("FirstName"),is(firstName));
    }

    @And("I validate that employees last name is {string}")
    public void iValidateThatEmployeesLastNameIs(String lastName) {
      assertThat(response.getBody().jsonPath().get("LastName"),is(lastName));
    }


    @When("I perform GET request for {string}")
    public void iPerformGETRequestFor(String url) {
       response= RestAssuredExtension.GETRequest(url);
    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        assertThat(response.getStatusCode(),equalTo(statusCode));
    }

    @And("employees first name should be {string}")
    public void employeesFirstNameShouldBe(String firstName) {
        assertThat(response.getBody().jsonPath().get("FirstName"),is(firstName));
    }

    @And("employees last name should be {string}")
    public void employeesLastNameShouldBe(String lastName) {
        assertThat(response.getBody().jsonPath().get("LastName"),is(lastName));
    }



}
