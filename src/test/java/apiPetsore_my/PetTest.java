package apiPetsore_my;

import helper_my.DataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models_my.Pet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class PetTest {
    private long petId;
    private Pet pet;
    private final String baseUrl = "https://petstore.swagger.io/v2";
    @BeforeMethod // create a pet
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
        petId = json.getLong("id");
        System.out.println(petId);
    }
    @AfterMethod
    public void deletePet(){
        Response response =
                given()
                        .baseUri(baseUrl+"/pet/"+petId)
//                        .baseUri(baseUrl)
//                        .basePath("/pet")
//                        .pathParam("petId",petId)
//                        .header("Accept","application/json")
                        .when()
//                        .delete("/{petId}")
                        .delete()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.getString("message"),String.valueOf(petId));
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
//        перевод String в объект
        JsonPath json = response.jsonPath();
        Pet responsePet = json.getObject("$",Pet.class);// $ -значит берем весь объект
//      System.out.println(responsePet.name);
//      Category category = json.getObject("category", Category.class);
//      long id = json.getLong("id");
      Assert.assertEquals(pet.name, responsePet.name);
    }
    @Test
    public void updatePet(){
        Pet newPet = DataGenerator.getPet();
        newPet.id = petId;
        Response response =
                given()
                        .baseUri(baseUrl)
                        .basePath("/pet")
                        .header("Accept","application/json")
                        .header("Content-type","application/json")
                        .body(pet)
                        .when()
                        .put()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath json = response.jsonPath();
        Pet responsePet = json.getObject("$",Pet.class);
        assertThat(responsePet, samePropertyValuesAs(newPet));
    }
}

