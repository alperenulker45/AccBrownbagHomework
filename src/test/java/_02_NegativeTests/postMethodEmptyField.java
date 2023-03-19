package _02_NegativeTests;

import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class postMethodEmptyField {

    @Test
    public void testPostEmptyFieldNegative(){

        baseURI = "https://gorest.co.in";
        String bearerToken = "Bearer 01083ffb5e1e1b2d06271697bedaf087f6fba1db36ce3415e640882f87df81d1";
        String generatedString = RandomStringUtils.randomAlphanumeric(3);

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "alperen");
        requestBody.put("gender", "");
        requestBody.put("email", "somemail"+generatedString+"@mail.com");
        requestBody.put("status", "active");

        given()
                .header("Authorization", bearerToken)
                .contentType(ContentType.JSON)
                .body(requestBody.toJSONString())
        .when()
                .post("/public/v2/users")
        .then()
                .log().body()
                .log().status()
                .statusCode(422);
    }
}
