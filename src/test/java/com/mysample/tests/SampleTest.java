package com.mysample.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.AssertJUnit.assertEquals;

public class SampleTest {

    final static Logger logger = Logger.getLogger(SampleTest.class);

    @BeforeTest
    public void setup() {
        System.out.println("Setup before test execution");
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.port = 443;
    }

    @Test
    public void whenMeasureResponseTime_thenOK() {
        Response response = RestAssured.get("/users/mkaya35");
        long timeInMS = response.time();
        long timeInS = response.timeIn(TimeUnit.SECONDS);

        assertEquals(timeInS, timeInMS/1000);
    }

    @Test
    public void whenValidateResponseTime_thenSuccess() {
        when().get("/users/mkaya35").then().time(lessThan(200L));
    }


    @AfterTest
    public void afterTest() {
        System.out.println("Teardown after test execution");
    }
}
