package _02_NegativeTests;

import io.restassured.http.*;
import org.junit.*;
import static io.restassured.RestAssured.*;

public class userNotFound404 {

    @Test
    public void testNegativeUserNotFound(){

        baseURI = "https://gorest.co.in";

        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/public/v2/users/9000000")
        .then()
                .log().body()
                .log().status()
                .statusCode(404);
    }
}
