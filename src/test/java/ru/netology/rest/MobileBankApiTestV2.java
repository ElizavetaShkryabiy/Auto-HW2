package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class MobileBankApiTestV2 {
    @Test
    void shouldReturnDemoAccounts() {
            given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                    .statusCode(200)
                    // static import для JsonSchemaValidator.matchesJsonSchemaInClasspath
                    .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
        ;
    }
}
