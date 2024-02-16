package org.example.gimazieva;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class BaseTest {
   Person pasha = new Person("Pasha", "student");
    Person masha = new Person("Masha","teacher");

    RequestSpecification requestSpec = given()
            .log().body().baseUri("https://postman-echo.com/");

    ResponseSpecification statusCodeSpec = expect().statusCode(200);

}
