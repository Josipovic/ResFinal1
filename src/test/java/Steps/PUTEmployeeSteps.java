package Steps;

import Utilities.RestAssuredExtension;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PUTEmployeeSteps {

    public static ResponseOptions<Response> response;

    @And("I perform PUT request for {string}")
    public void iPerformPUTRequestFor(String url, DataTable table) {
        var data=table.cells();
        HashMap<String,String> bodyContent=new HashMap<>();
        bodyContent.put("Id",data.get(1).get(0));
        bodyContent.put("FirstName",data.get(1).get(1));
        bodyContent.put("LastName",data.get(1).get(2));
        bodyContent.put("Age",data.get(1).get(3));
        bodyContent.put("Salary",data.get(1).get(4));
        bodyContent.put("Department",data.get(1).get(5));

        Map<String,String> pathParameter=new HashMap<>();
        pathParameter.put("Id",data.get(1).get(0));

     RestAssuredExtension.PUTWithBodyAndPathParams(url,bodyContent,pathParameter);
    }

    @Then("I should see the body with First Name as {string}")
    //baca failed to parse json document
    public void iShouldSeeTheBodyWithFirstNameAs(String sFirstName) {
        assertThat(response.getBody().jsonPath().get("FirstName"),is(sFirstName));
    }
}
