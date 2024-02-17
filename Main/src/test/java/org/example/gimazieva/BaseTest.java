package org.example.gimazieva;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class BaseTest {
    Body stringCheck = new Body("Check hello");

    RequestSpecification requestSpec = given().baseUri("https://postman-echo.com/");

    ResponseSpecification statusCodeSpec = expect().statusCode(200);

}
