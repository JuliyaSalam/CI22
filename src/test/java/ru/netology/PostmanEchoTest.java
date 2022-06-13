package ru.netology;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostmanEchoTest {
    @Test
    void shouldReturnDemoAccounts () {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }
    @Test
    void shouldReturnDemoAccounts1 () {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .header("Content-Type", "application/json; charset=UTF-8")
                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body("data", equalTo("some data"))
        ;
    }
}
