package helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Credentials;

import static io.restassured.RestAssured.given;

public class Token {
    public static String get(String username,String password, String url){
        Credentials credentials = new Credentials(username,password);
        Response response =
                given()
                        .baseUri(url)
                        .basePath("api/me")
                        .header("Accept","application/json")
                        .header("Content-type","application/json")
                        .body(credentials)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath json = response.jsonPath();
        return json.getString("token");
    }
}
