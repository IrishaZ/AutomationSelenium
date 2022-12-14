package apiPetsore;

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
        JsonPath json = response.jsonPath();
        petId=json.getLong("id");
        System.out.println(petId);
    }
    @AfterMethod
    public void deletePet(){
        given().baseUri(baseUrl+"/pet/"+petId).when().delete().then().statusCode(200);
    }
    @Test
    public void getPetById(){
        Response response =
                given()
                        .baseUri(baseUrl)
                        .basePath("/pet")
                        .pathParam("petId",petId)
                        .header("Accept","application/json")
                .when()
                        .get("/{petId}")
                .then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath json = response.jsonPath();
        Pet responsePet = json.getObject("$", Pet.class);
        Assert.assertEquals(pet.name,responsePet.name);
    }
    @Test
    public void updatePet(){
        Pet updatedPet = DataGenerator.getPet();
        updatedPet.id = petId;
        Response response =
                given()
                        .baseUri(baseUrl)
                        .basePath("/pet")
                        .header("Accept","application/json")
                        .header("Content-type","application/json")
                        .body(updatedPet)
                        .when()
                        .put()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath json = response.jsonPath();
        Pet petResponse = json.getObject("$", Pet.class);
        Assert.assertEquals(updatedPet.name,petResponse.name);
    }
}
