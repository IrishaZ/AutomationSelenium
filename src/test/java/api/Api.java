package api;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
}
