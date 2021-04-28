package org.ibm.joyil.bookservice;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.jsoup.select.Evaluator.ContainsText;

@QuarkusTest
public class BookServiceResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/bookinfo/getBookInfo/java")
          .then()
             .statusCode(200);
    }

}