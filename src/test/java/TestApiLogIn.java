import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Credentials;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestApiLogIn {
    @Test
    public void logInParameters(){
        Response response=given()
                .log().all()
                .params("email", "irina.zhukova@testpro.io",
                        "password", "te$t$tudent84")
                .when().post("https://qa.koel.app/api/me")
                .then().statusCode(200).extract().response();
        String token = response.path("token");
        String authorization = "Bearier "+token;
        System.out.println(token);
    }
    @Test
    public void logInBodyString(){
        String requestBody = String.format("{\"email\":\"%s\",\"password\":\"%s\"}",
                "irina.zhukova@testpro.io", "te$t$tudent84");
        Response response=given()
                .log().all()
                .baseUri("https://qa.koel.app/api/me")
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(requestBody)
                .when().post()
                .then().statusCode(200).extract().response();
    }
    @Test
    public void logInBodyObject(){
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.addHeader("Accept","application/json");
        RequestSpecification requestSpec=requestSpecBuilder.build();

        Credentials userCredentials = new Credentials("irina.zhukova@testpro.io","te$t$tudent84");
        Response response=given()
                .log().headers().log().body().log().uri()
                .spec(requestSpec)
                .baseUri("https://qa.koel.app/api/me")
                .body(userCredentials)
                .when().post()
                .then().statusCode(200).extract().response();
    }

}
