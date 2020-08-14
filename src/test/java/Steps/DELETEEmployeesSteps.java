package Steps;

import Utilities.RestAssuredExtension;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import org.testng.Assert;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.*;
public class DELETEEmployeesSteps extends ReadProperties {
    public static ResponseOptions<Response> response;

    @When("I perform POST request for {string}")
    public void iPerformPOSTRequestFor(String url) {
        HashMap<String,String> bodyContent=new HashMap<>();
        bodyContent.put("Id",propDELETEPOST.getProperty("Id"));
        bodyContent.put("FirstName",propDELETEPOST.getProperty("FirstName"));
        bodyContent.put("LastName",propDELETEPOST.getProperty("LastName"));
        bodyContent.put("Age",propDELETEPOST.getProperty("Age"));
        bodyContent.put("Salary",propDELETEPOST.getProperty("Salary"));
        bodyContent.put("Department",propDELETEPOST.getProperty("Department"));

        response= RestAssuredExtension.POSTWithBody(url,bodyContent);
    }

    @Then("I should see status code {int}")
    public void iShouldSeeStatusCode(int statusCode) {
        assertThat(response.getStatusCode(),equalTo(statusCode));
    }

    @When("I perform GET for {string}")
    public void iPerformGETFor(String url) {
        response=RestAssuredExtension.GETRequest(url);
    }

    @Then("I should see employees first name as {string}")
    public void iShouldSeeEmployeesFirstNameAs(String firstName) {
        assertThat(response.getBody().jsonPath().get("FirstName"),is(firstName));
    }

    @And("last name as {string}")
    public void lastNameAs(String lastName) {
        assertThat(response.getBody().jsonPath().get("LastName"),is(lastName));
    }

    @When("I perform DELETE request at {string}")
    public void iPerformDELETERequestAt(String url) {
        response=RestAssuredExtension.DELETERequest(url);
    }

    @Then("status code has to be {int}")
    public void statusCodeHasToBe(int statusCode) {
        assertThat(response.getStatusCode(),equalTo(statusCode));
    }

    @When("I use GET operation at {string}")
    public void iUseGETOperationAt(String url) {
    response=RestAssuredExtension.GETRequest(url);
    }

    @Then("I should not see employees first name as {string}")
    public void iShouldNotSeeEmployeesFirstNameAs(String firstName) {

        assertThat(response.getBody().jsonPath().get("FirstName"),IsNot.not(firstName));
    }

    @And("I should not see employees last name as {string}")
    public void iShouldNotSeeEmployeesLastNameAs(String lastName) {
        assertThat(response.getBody().jsonPath().get("LastName"),IsNot.not(lastName));

    }
}
