package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification Request;

    public RestAssuredExtension() {
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        RestAssured.useRelaxedHTTPSValidation();
        builder.setBaseUri("https://localhost:44333/");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static void GETWithPathParameter(String url, Map<String, String> pathParams) {
        //Act
        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ResponseOptions<Response> GETRequest(String url) {
        //Act
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ResponseOptions<Response> POSTWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body)  {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }
    public static ResponseOptions<Response> POSTWithBody(String url,Map<String, String> body)  {
        Request.contentType(ContentType.JSON);
        Request.body(body);
        return Request.post(url);
    }
    public static ResponseOptions<Response> DELETEWithPathParams(String url,Map<String, String> pathParams)  {
        Request.pathParams(pathParams);
        return Request.delete(url);
    }
    public static ResponseOptions<Response> DELETERequest(String url)  {

        return Request.delete(url);
    }
    public static ResponseOptions<Response> GETWithPathParams1(String url,Map<String, String> pathParams)  {
        Request.pathParams(pathParams);
        return Request.get(url);
    }

    public static ResponseOptions<Response> PUTWithBodyAndPathParams(String url, Map<String,String> body, Map<String,String> pathParams) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.put(url);
    }
    public static ResponseOptions<Response> GETWithToken(String url, String token) {

        try {
            Request.header(new Header("Authorization", "Bearer " + token));
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    //popravi ovo
    public static ResponseOptions<Response> POSTWithFormParams(String url,Map<String,String> headers)  {
        Request.header("Content-Type", "application/x-www-form-urlencoded");
        Request.headers(headers);
        return Request.post(url);
    }
    public static ResponseOptions<Response> POSTWithText(String url,String text)  {

        Request.contentType(ContentType.TEXT);
        Request.body(text);
        return Request.post(url);
    }


}