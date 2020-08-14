package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestAssuredGeneric {

    private RequestSpecBuilder builder=new RequestSpecBuilder();
    private String method;
    private String url;

    public RestAssuredGeneric(String uri,String method,String token){
        this.url="https://localhost:44333/"+ uri;
        this.method=method;

        if(token!=null)
        {
            builder.addHeader("Authorization","Bearer" + token);
        }
    }

    private ResponseOptions<Response> ExecuteAPI() {
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);

        if(this.method.equalsIgnoreCase(API.APIMethods.POST))
            return request.post(this.url);
        else if(this.method.equalsIgnoreCase(API.APIMethods.DELETE))
            return request.delete(this.url);
        else if(this.method.equalsIgnoreCase(API.APIMethods.GET))
            return request.get(this.url);
        else if(this.method.equalsIgnoreCase(API.APIMethods.PUT))
            return request.put(this.url);
        return null;
    }

    public String Authenticate(Map<String,String> body){
       builder.setBody(body);
      return  ExecuteAPI().getBody().jsonPath().get("access_token");
    }
    public String AuthenticateWithText(String text){
        builder.setContentType(ContentType.TEXT);
        builder.setBody(text);
        return ExecuteAPI().getBody().jsonPath().get("access_token");
    }
    public ResponseOptions<Response> RequestWithQueryParams(Map<String,String> queryParams){
        builder.addQueryParams(queryParams);
        return ExecuteAPI();
    }
    public ResponseOptions<Response> RequestWithBody( Map<String, String> body) {
        builder.setBody(body);

        return ExecuteAPI();
    }
}
