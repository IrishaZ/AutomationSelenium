package apiPetsore_my;

import helper.DataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Category;
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
    @Test
    public void getPetById(){
        Response response =
                given()
                        .baseUri(baseUrl)
                        .basePath("/pet")
                        .pathParam("petId",11115)
                        .header("Accept","application/json")
                .when()
                        .get("/{petId}")
                .then()
                        .statusCode(200)
                        .extract()
                        .response();

    response.prettyPrint();
//        перевод String в объект
    JsonPath json = response.jsonPath();
    Pet responsePet = json.getObject("$",Pet.class);
    System.out.println(responsePet.name);
    Category category = json.getObject("category", Category.class);
    long id = json.getLong("id");
    String name = json.getString("id");
    }
}
