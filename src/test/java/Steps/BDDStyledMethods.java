package Steps;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.CoreMatchers.*;
public class BDDStyledMethods {

    public static Response GETValidate(String sEndpoint,String sBodyParameter,String sBodyParameterToValidate){
        given().contentType(ContentType.JSON).when().get(sEndpoint).then().body(sBodyParameter,is(sBodyParameterToValidate));
       return null;
    }

    public static Response GETValidateWithPathParameter(String sEndpoint, String sPathParameter, String sBodyParameter, String sBodyParameterToValidate){
        given().contentType(ContentType.JSON).when().get(sEndpoint+sPathParameter).then().body(sBodyParameter,is(sBodyParameterToValidate));
        return null;
    }

    //ne dodajem id,jer entity framework u asp netu sam to radi
    public static void POSTRequest(String sEndpoint,String sBodyParameter,String sBodyParameterToValidate
            ,String sFirstName,String sLastName,String sAge,String sSalary,String sDepartment){
        HashMap<String,String> bodyContent=new HashMap<>();
        bodyContent.put("FirstName",sFirstName);
        bodyContent.put("LastName",sLastName);
        bodyContent.put("Age",sAge);
        bodyContent.put("Salary",sSalary);
        bodyContent.put("Department",sDepartment);
        given().contentType(ContentType.JSON).with().body(bodyContent).when().post(sEndpoint).then()
                .body(sBodyParameter, Is.is(sBodyParameterToValidate));
    }

    //ovo radi
    public static Response Test(){
      Response response=  given().
              formParam("username","kata@nekimail.com").
              formParam("password","Kata123!Katic")
              .formParam("grant_type","password")
              .post("https://localhost:44333/token");
        return  response;
    }

    public static Response GETWithAuthTokenHeader(String token){
        Response response=given().header("Authorization","Bearer " + token).when()
                .get("https://localhost:44333/api/phones");

        return response;
    }

}
