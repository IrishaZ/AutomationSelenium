package helper_my;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models_my.Credentials;
import models_my.PlaylistRequest;

import static io.restassured.RestAssured.given;

public class Token  {
    public static String getToken(String email, String password, String url){
        Credentials credentials = new Credentials(email,password);
        Response response =
            given()
                .baseUri(url)
                .basePath("/api/me")
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(credentials)
                .when()
                .post()
                .then()
                .statusCode(200).extract().response();
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString("token");
    }
}
