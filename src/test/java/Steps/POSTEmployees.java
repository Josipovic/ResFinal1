package Steps;

import Utilities.RestAssuredExtension;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
public class POSTEmployees extends ReadProperties {

    public static ResponseOptions<Response> response;

    @When("I perform a POST request at {string}")
    public void iPerformAPOSTRequestAt(String url) {
        HashMap<String,String> bodyContent=new HashMap<>();
        bodyContent.put("Id",propPOST.getProperty("Id"));
        bodyContent.put("FirstName",propPOST.getProperty("FirstName"));
        bodyContent.put("LastName",propPOST.getProperty("LastName"));
        bodyContent.put("Age",propPOST.getProperty("Age"));
        bodyContent.put("Salary",propPOST.getProperty("Salary"));
        bodyContent.put("Department",propPOST.getProperty("Department"));

      response= RestAssuredExtension.POSTWithBody(url,bodyContent);
    }

    @Then("I should see status code as {int}")
    public void iShouldSeeStatusCodeAs(int statusCode) {
    assertThat(response.getStatusCode(),equalTo(statusCode));
    }

    @When("I perform a GET request at {string}")
    public void iPerformAGETRequestAt(String url) {
        response=RestAssuredExtension.GETRequest(url);
    }

    @Then("status shall be {int}")
    public void statusShallBe(int statusCode) {
        assertThat(response.getStatusCode(),equalTo(statusCode));
    }

    @And("employees age should be {int}")
    public void employeesAgeShouldBe(int age) {
        assertThat(response.getBody().jsonPath().get("Age"),is(age));

    }

    @And("employees department should be {string}")
    public void employeesDepartmentShouldBe(String department) {
        assertThat(response.getBody().jsonPath().get("Department"),is(department));

    }


}
