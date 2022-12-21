package pageObjectTests;

import adapter.DbAdapter;
import helper.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.CreatePlaylistRequest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import static io.restassured.RestAssured.given;

public class HybridTest extends BaseTest{
    private String playlistName;
    private int playlistId;

    @BeforeMethod
    public void createPlaylist(){
        System.out.println(url);
        playlistName = faker.funnyName().name();
        CreatePlaylistRequest playlist = new CreatePlaylistRequest(playlistName);
        Response response =
                given()
                        .baseUri(url)
                        .basePath("api/playlist")
                        .header("Accept","application/json")
                        .header("Content-type","application/json")
                        .header("Authorization","Bearer "+token)
                        .body(playlist)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath json = response.jsonPath();
        playlistId=json.getInt("id");
        System.out.println(playlistId);
    }
    @AfterMethod
    public void deletePlaylist(){

        given().baseUri(url+"api/playlist/"+playlistId)
                .header("Authorization","Bearer "+token)
                .when().delete().then().statusCode(200);
    }

    @Test
    public void hybridRenamePlaylist(){
        MainPage mainPage = login();
        String newName = faker.artist().name();
        mainPage.renamePlaylist(playlistId,newName);
        String nameFromDb = DbAdapter.getPlaylistName(playlistId);
        Assert.assertEquals(nameFromDb,newName);
    }
}
