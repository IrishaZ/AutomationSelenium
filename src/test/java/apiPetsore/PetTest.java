package apiPetsore;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Category;
import models.Pet;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class PetTest {
    @Test
    public void getPetById(){
        String baseUrl = "https://petstore.swagger.io/v2";
        Response response =
                given()
                        .baseUri(baseUrl)
                        .basePath("/pet")
                        .pathParam("petId",111)
                        .header("Accept","application/json")
                .when()
                        .get("/{petId}")
                .then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath json = response.jsonPath();
        Pet responsePet = json.getObject("$", Pet.class);

        Category category = json.getObject("category", Category.class);
        long id = json.getLong("id");
        String n = json.getString("name");

        System.out.println(responsePet.name);
    }
}
