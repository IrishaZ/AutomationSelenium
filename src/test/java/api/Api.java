package api;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Playlist;
import models.UserProfile;
import sql.Queries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.UNDEFINED_PORT;
import static io.restassured.RestAssured.given;

public class Api {
    public static Set<String> getPlaylistSongs(int playlistId, String token, String url) {
        Response response = given()
                .baseUri(url + "/api/playlist/" + playlistId + "/songs")
                .header("Authorization", "Bearer " + token)
                .when().get()
                .then().statusCode(200).extract().response();
        JsonPath json = response.jsonPath();
        List<String> playlistSongsList = json.getList("");
        Set<String> playlistSongs=new HashSet<>(playlistSongsList);
        return playlistSongs;
    }
        public static void deletePlaylist(Integer playlistId, String token, String url) {
        given().baseUri(url + "/api/playlist/" + playlistId)
                .header("Authorization", "Bearer " + token)
                .when().delete()
                .then().statusCode(200);
        System.out.println("Playlist deleted");
    }
    public static void deleteAllUserPlaylist(String email, String url,String token) throws SQLException {
        int userId= Queries.getUserId(email);
        List<Integer> allPlaylistsId=Queries.getUserPlaylists(userId);
        System.out.println(allPlaylistsId);
        System.out.println(allPlaylistsId.size());
        allPlaylistsId.forEach(x->{
            System.out.println(x);
            Api.deletePlaylist(x,token,url);
        });
    }
    public static void updateUser(String url, String token, String name, String email, String current_password, String new_password){
        UserProfile userProfile=new UserProfile(name,email,current_password,new_password);
        Response response =
            given()
                .baseUri(url+"/api/me")
                .header("Accept","application/json")
                .header("Content-type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(userProfile)
            .when().put()
                .then()
                .statusCode(200)
                .extract().response();
        response.prettyPrint();
    }

//    ------------------
    public static List<Playlist> getPlaylists(String token, String url) {
        List<Playlist> allPlaylists=new ArrayList<>();
        Response response = given()
                .baseUri(url + "/api/playlist/")
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        JsonPath json = response.jsonPath();
        allPlaylists=json.getList("");
        return allPlaylists;
    }

    public static String getPlaylists1(String token, String url) throws JsonProcessingException {
        List<Playlist> allPlaylists=new ArrayList<>();
        Response response = given()
                .baseUri(url + "/api/playlist/")
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        String jsonString= response.body().asString();
        return  jsonString;
    }
    public static List<Playlist> getPlaylists2(String token, String url) {
        List<Playlist> allPlaylists=new ArrayList<>();
        Response response = given()
                .baseUri(url + "/api/playlist/")
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        String jsonString= response.body().asString();
        allPlaylists=convertJsonToEntities(jsonString);
        return allPlaylists;
    }

    private static List<Playlist> convertJsonToEntities(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, new TypeReference<List<Playlist>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception according to your needs
            return null;
        }
    }
}
