package pageObjectTests;
        import com.fasterxml.jackson.core.JsonProcessingException;
        import models.Playlist;
        import sql.Queries;
        import api.Api;
        import listener.RetryAnalyzer;
        import org.testng.Assert;
        import org.testng.annotations.Test;
        import pageObjects.MainPage;
        import helper.TestData;
        import java.sql.SQLException;
        import java.util.*;

        import static io.restassured.RestAssured.given;

public class SmartPlaylistTests extends BaseTest {
    private String playlistName;
    private int playlistId;
    private Set <String> sqlSongs;
    private Set <String> apiSongs;
    private String successMessage;
//    @AfterMethod
//    public void deletePlaylist() {
//        token = Token.getToken(email, password, url);
//        given().baseUri(url + "/api/playlist/" + playlistId)
//                .header("Authorization", "Bearer " + token)
//                .when().delete()
//                .then().statusCode(200);
//        System.out.println("Playlist deleted");
//    }
    @Test (enabled = false,dataProvider = "createSP_OneRule_DefaultValues", dataProviderClass = TestData.class)
    public void createNewSmartPlaylistWithDefaultNameAndModel(String queryName, String sqlQuery) throws InterruptedException, SQLException {
        playlistName = faker.funnyName().name();
        successMessage = "Created playlist \"" + playlistName + ".\"";
        MainPage mainPage = login();
        mainPage.createSP_OneRule_DefaultValues(playlistName,queryName);
        playlistId= Queries.getPlaylistIdByName(playlistName);
        Assert.assertEquals(successMessage, mainPage.getSuccessBanner().getText());
        playlistId= Queries.getPlaylistIdByName(playlistName);
        sqlSongs=Queries.getSongsIdByCriteria(sqlQuery);
        apiSongs=Api.getPlaylistSongs(playlistId,token,url);
        Assert.assertEquals( sqlSongs, apiSongs);
        }

    @Test (enabled = false, dataProvider = "createSP_OneRule", dataProviderClass = TestData.class, retryAnalyzer = RetryAnalyzer.class)
    public void createNewSmartPlaylist(String model,String operator, String queryName, String sqlQuery) throws InterruptedException, SQLException {
        playlistName = faker.funnyName().name();
        successMessage = "Created playlist \"" + playlistName + ".\"";
        MainPage mainPage = login();
        mainPage.createSP_OneRule_CustomValues(playlistName,model,operator,queryName);
        Assert.assertEquals(successMessage, mainPage.getSuccessBanner().getText());
        playlistId= Queries.getPlaylistIdByName(playlistName);
        sqlSongs=Queries.getSongsIdByCriteria(sqlQuery);
        apiSongs=Api.getPlaylistSongs(playlistId,token,url);
        Assert.assertEquals( sqlSongs, apiSongs);
    }
    @Test
    public void playlistTest() throws SQLException, JsonProcessingException {
//        int playlistId=77203;
////        int playlistIdApi;
//        int userId=Queries.getUserId(email);
//        PlaylistModel playlistApi = new PlaylistModel();
        List<Playlist> rules= Api.getPlaylists2(token,url);

//        rules.stream().toArray();

//        String jsonString = Api.getPlaylists1(token, url);
//        System.out.println(jsonString);
//        String resultString = jsonString.substring(1, jsonString.length() - 1);
//        System.out.println(resultString);
//        Object jsonObject=resultString;
//        System.out.println(jsonObject);

//        PlaylistModel playlist= new PlaylistModel();
////        for(int n=0;n<allPlaylists.size();n++){
////            System.out.println(n);
//            int n=0;
////            playlistApi=allPlaylists.get(0);;
////        System.out.println(playlistApi);
////            if(playlistApi.getId()==playlistId){
////                System.out.println(n);
//        System.out.println(allPlaylists.get(0).getId());
//        System.out.println(allPlaylists.get(0).getName());
//        System.out.println(allPlaylists.get(0).getRules());
//        System.out.println(allPlaylists.get(0).getIs_smart());

//        }
        }
//        System.out.println(playlist);
//    }
//        playlist=allPlaylists.get(0);
//        System.out.println(allPlaylists);
//        PlaylistModel playlist= new PlaylistModel();
//        System.out.println(playlist);
//        Iterator<PlaylistModel> it= allPlaylists.iterator();
//        while (it.hasNext()){
//            playlist =it.next();
//            System.out.println(playlist);
//            playlistIdApi=playlist.getId();
//            System.out.println(playlistIdApi);
//            if (playlistIdApi==playlistId){
//                rules=playlist.getRules();
//                System.out.println(rules);
//            }
//        }
//        System.out.println(rules);


//        List<Object> allPlaylists = Api.getPlaylists(token,url);
//        System.out.println(allPlaylists);
}

//        System.out.println("sqlSongs");
//        System.out.println(sqlSongs);
//        System.out.println("apiSongs");
//        System.out.println(apiSongs);