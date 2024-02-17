package org.example.gimazieva;

import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class EchoTest extends BaseTest{
    @Test
    public void checkGetRequest(){
        requestSpec
                .when()
               .get("/get?foo1=bar1&foo2=bar2")
               .then()
               .spec(statusCodeSpec)
               .assertThat().body("args.foo1", equalTo("bar1"))
               .assertThat().body("args.foo2", equalTo("bar2"));
    }
    @Test
    public void checkPostRawText(){
        requestSpec
                .body(stringCheck.getStr())
                .contentType("application/json")
                .when()
                .post("/post")
                .then()
                .spec(statusCodeSpec)
                .assertThat().body("data", equalTo(stringCheck.getStr()));
    }
    @Test
    public void checkPostFormData() {
        requestSpec
                .multiPart("foo1", "bar1")
                .multiPart("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .spec(statusCodeSpec)
                .assertThat().body("form.foo1", equalTo("bar1"))
                .assertThat().body("form.foo2", equalTo("bar2"));
    }
    @Test
    public void checkPutRequest() {
        requestSpec
                .body(stringCheck.getStr())
                .contentType("text/plain")
                .when()
                .put("put/")
                .then()
                .statusCode(200)
                .assertThat().body("data", equalTo(stringCheck.getStr()));

    }
    @Test
    public void checkPatchRequest() {
        requestSpec
                .body(stringCheck.getStr())
                .contentType("text/plain")
                .when()
                .patch("/patch")
                .then()
                .spec(statusCodeSpec)
                .assertThat().body("data", equalTo(stringCheck.getStr()));
    }
    @Test
    public void checkDelRequest() {
        requestSpec
                .contentType("text/plain")
                .body(stringCheck.getStr())
                .when()
                .delete("/delete")
                .then()
                .spec(statusCodeSpec)
                .assertThat().body("data", equalTo(stringCheck.getStr()));
    }
}
