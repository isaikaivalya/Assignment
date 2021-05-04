package com.tw.assignment.restassured.postmethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class postMethod {

    @Test
    public void create()
    {
        RestAssured.baseURI = "https://reqres.in/";
        String reqbody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .body(reqbody)
                .post("api/users");

        System.out.println(postResponse.getStatusCode());
        Assert.assertEquals(postResponse.statusCode(),201,"Expected 201 but found "+postResponse.statusCode());
        System.out.println(postResponse.asPrettyString());
    }

    @Test
    public void registerSuccessful()
    {
        RestAssured.baseURI = "https://reqres.in/";
        String reqbody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .and()
                .body(reqbody)
                .when()
                .post("api/register");

        System.out.println(postResponse.getStatusCode());
        Assert.assertEquals(postResponse.statusCode(),200,"Expected 200 but found "+postResponse.statusCode());
        System.out.println(postResponse.asPrettyString());
    }

    @Test
    public void registerUnsuccessful()
    {
        RestAssured.baseURI = "https://reqres.in/";
        String reqbody = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .and()
                .body(reqbody)
                .when()
                .post("api/register");

        System.out.println(postResponse.getStatusCode());
        Assert.assertEquals(postResponse.statusCode(),400,"Expected 400 but found "+postResponse.statusCode());
        System.out.println(postResponse.asPrettyString());
    }

    @Test
    public void loginSuccessful()
    {
        RestAssured.baseURI = "https://reqres.in/";
        String reqbody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .and()
                .body(reqbody)
                .when()
                .post("api/login");

        System.out.println(postResponse.getStatusCode());
        Assert.assertEquals(postResponse.statusCode(),200,"Expected 200 but found "+postResponse.statusCode());
        System.out.println(postResponse.asPrettyString());
    }

    @Test
    public void loginUnsuccessful()
    {
        RestAssured.baseURI = "https://reqres.in/";
        String reqbody = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .and()
                .body(reqbody)
                .when()
                .post("api/login");

        System.out.println(postResponse.getStatusCode());
        Assert.assertEquals(postResponse.statusCode(),400,"Expected 400 but found "+postResponse.statusCode());
        System.out.println(postResponse.asPrettyString());
    }

}
