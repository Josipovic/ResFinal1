package Steps;

import Utilities.API;
import Utilities.RestAssuredExtension;
import Utilities.RestAssuredGeneric;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class GETPhonesWithAuth extends ReadProperties {

    String token;
    RestAssuredGeneric restAssuredGeneric;
    public static ResponseOptions<Response> response;

    @When("I perform authentication for {string} with login body")
    public void iPerformAuthenticationForWithLoginBody(String uri) {
        HashMap<String,String> loginBody=new HashMap<>();
        loginBody.put("Email",propLOGIN.getProperty("Email"));
        loginBody.put("Password",propLOGIN.getProperty("Password"));
        loginBody.put("ConfirmPassword",propLOGIN.getProperty("ConfirmPassword"));
        restAssuredGeneric=new RestAssuredGeneric(uri, API.APIMethods.POST,null);
        restAssuredGeneric.RequestWithBody(loginBody);
    }

    @Then("I perform POST request at endpoint {string} with text")
    public void iPerformPOSTRequestAtEndpointWithText(String uri) {
        restAssuredGeneric=new RestAssuredGeneric(uri, API.APIMethods.POST,null);
        token= restAssuredGeneric.AuthenticateWithText(propLOGIN.getProperty("text"));
    }

    @And("I perform GET request  for {string}")
    public void iPerformGETRequestFor(String uri) {
        restAssuredGeneric=new RestAssuredGeneric(uri, API.APIMethods.GET,token);
        response= RestAssuredExtension.GETWithToken(uri,token);
    }

    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) {
       assertThat(response.getStatusCode(),equalTo(statusCode));
    }

    @Then("I perform POST request for {string} with body")
    public void iPerformPOSTRequestForWithBody(String uri) {
        HashMap<String,String> body=new HashMap<>();
        body.put("Id",propPOSTPhones.getProperty("Id"));
        body.put("Name",propPOSTPhones.getProperty("Name"));
        body.put("Price",propPOSTPhones.getProperty("Price"));
        body.put("Year",propPOSTPhones.getProperty("Year"));
        restAssuredGeneric=new RestAssuredGeneric(uri, API.APIMethods.POST,token);
        response=restAssuredGeneric.RequestWithBody(body);
    }

    @When("I perform GET request at endpoint {string}")
    public void iPerformGETRequestAtEndpoint(String url) {
        response=RestAssuredExtension.GETWithToken(url,token);
    }

    @Then("I should see Name of the phone as {string}")
    public void iShouldSeeNameOfThePhoneAs(String name) {
        assertThat(response.getBody().jsonPath().get("Name"),is(name));
    }
}
