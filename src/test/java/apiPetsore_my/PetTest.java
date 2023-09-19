package apiPetsore_my;

import helper.DataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class PetTest {
    private long petId;
    private Pet pet;
    private final String baseUrl = "https://petstore.swagger.io/v2";
    @BeforeMethod
    public void createPet(){
        pet = DataGenerator.getPet();

        Response response =
                given()
                        .baseUri(baseUrl)
                        .basePath("/pet")
                        .header("Accept","application/json")
                        .header("Content-type","application/json")
                        .body(pet)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        response.prettyPrint();
    }
}
