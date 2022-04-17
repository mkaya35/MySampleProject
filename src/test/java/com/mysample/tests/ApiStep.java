package com.mysample.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.log4testng.Logger;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.AssertJUnit.assertEquals;

public class ApiStep {

    final static Logger logger = Logger.getLogger(ApiStep.class);
    public static Response response;

    @Given("existing server application {string}")
    public void existing_server_application(String baseUri){
        RestAssured.baseURI = baseUri;
        RestAssured.port = 443;
    }

    @Then("on GET request to {string} returns expected users list")
    public void returns_expected_users_list(String endpoint){
        when().get(endpoint).then().statusCode(200)
                .assertThat().body("data.first_name",hasItems("George","Janet"));
    }

    @Then("on GET request to {string} it returns expected welcome message")
    public void returns_expected_welcome_message(String endpoint){
        when().get(endpoint).then().statusCode(200)
                .assertThat().body("data.first_name",equalTo("Janet"));
    }

    @Then("on GET request to {string} it returns {int} status code")
    public void returns_nonexisting_user(String endpoint,int statusCode){
        when().get(endpoint).then().statusCode(statusCode);
    }
}
