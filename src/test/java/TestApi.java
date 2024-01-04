
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.InnerRule;
import models.Playlist;
import models.Rule;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApi {
    RequestSpecification requestSpec;
    String baseUrl="https://qa.koel.app/";
    String password= "te$t$tudent84";
    String email="irina.zhukova@testpro.io";

    @BeforeClass
    public void logInParameters(){
        RequestSpecBuilder builder =new RequestSpecBuilder();

        Response response=given()
                .params("email", email,
                        "password", password)
                .when().post(baseUrl+"api/me")
                .then().statusCode(200).extract().response();
        String token = response.path("token");
        String authorization = "Bearer "+token;
        builder.addHeader("Authorization",authorization);
        requestSpec=builder.build();
    }
    @Test
    public void verifyPlaylistNameTestPro(){
        Response response=given()
                .log().headers().log().uri()
                .spec(requestSpec)
                .when().get(baseUrl+"api/playlist")
                .then().statusCode(200).extract().response();
        String responseBody=response.body().asString(); // for debugging //  response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        Playlist[] playlists=response.as(Playlist[].class);//as array by response
//        Playlist[] playlists1=jsonPath.getObject("$",Playlist[].class);
//        List<Playlist> playlists2=jsonPath.getList("");
        Assert.assertEquals(playlists[0].getName(),"playlist");

        Rule[] rules=jsonPath.getObject("rules[1]", Rule[].class);
        InnerRule[] innerRules=rules[0].getRules();
        InnerRule firstRule=innerRules[0];
        System.out.println(firstRule);
        int idSecondPlaylist=jsonPath.getInt("id[1]");
        String nameSecondPlaylst=jsonPath.getString("name[1]");
        System.out.println(idSecondPlaylist);
        System.out.println(nameSecondPlaylst);
    }
}
