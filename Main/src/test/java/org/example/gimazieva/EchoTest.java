package org.example.gimazieva;

import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class EchoTest extends BaseTest{
    @Test
    public void checkGetRequest(){
       requestSpec.
               when().get("/get")
               .then()
               .spec(statusCodeSpec);
    }
    @Test
    public void checkPostRawText(){
        requestSpec
                .contentType("application/json")
                .when().post("/post").then()
                .body()
                .spec(statusCodeSpec);
    }
}
