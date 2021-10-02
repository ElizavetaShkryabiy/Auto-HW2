package ru.netology.rest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestMain {
    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
                .body("", hasSize(3))
                .body("[0].currency", equalTo("RUB"))
                .body("[0].balance", greaterThanOrEqualTo(0))
                .body("every{ it.balance >= 0 }", is(true))
        ;
    }
}
