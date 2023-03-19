package _01_PositiveTests;

import io.restassured.http.*;
import org.junit.*;
import static io.restassured.RestAssured.*;

public class getMethodPositive {

    @Test
    public void testGetMethod(){

        baseURI = "https://gorest.co.in";

        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/public/v2/users")
        .then()
                .log().body()
                .log().status()
                .statusCode(200);
    }
}
