package pageObjectTests;

import adapter.Queries;
import helper.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.PlaylistRequest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MainPage;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class PlaylistTestsHybrid extends BaseTest{
    private String playlistName;
    private int playlistId;

    @BeforeMethod
    public void createPlaylist(){
        playlistName=faker.funnyName().name();
        PlaylistRequest playlistRequest = new PlaylistRequest(playlistName);
        Response response = given()
                .baseUri(url)
                .basePath("/api/playlist")
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Authorization", "Bearer "+token)
                .body(playlistRequest)
                .when().post()
                .then().statusCode(200).extract().response();
        JsonPath json = response.jsonPath();
        playlistId = json.getInt("id");
        playlistName =json.getString("name");
        System.out.println("Before method in test");
        System.out.println(playlistId);
        System.out.println(playlistName);
    }

    @AfterMethod
    public void deletePlaylist(){
        token = Token.getToken(email,password,url);
        given().baseUri(url+"/api/playlist/"+ playlistId)
               .header("Authorization", "Bearer "+token)
               .when().delete()
               .then().statusCode(200);
        System.out.println("After method in test");
    }
    @Test
    public void renamePlaylistHybrid() throws InterruptedException, SQLException {
        String newPlaylistName = faker.funnyName().name();
        MainPage mainPage =login();
        mainPage.renamePlaylist(playlistId,newPlaylistName);
//        Assert.assertTrue(mainPage.playlistExist(playlistId,newPlaylistName));
        Assert.assertEquals(newPlaylistName, Queries.getPlaylistNameById(playlistId));
    }
}
