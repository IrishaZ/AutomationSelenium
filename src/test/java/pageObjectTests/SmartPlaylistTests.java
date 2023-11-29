package pageObjectTests;
        import adapter.Queries;
        import api.Api;
        import enums.FirstDropdown;
        import enums.SecondDropdown;
        import helper.Token;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.Test;
        import pageObjects.MainPage;
        import testData.TestData;

        import java.sql.SQLException;
        import java.util.Set;

        import static io.restassured.RestAssured.given;

public class SmartPlaylistTests extends BaseTest {
    private String playlistName;
    private int playlistId;
    private Set <String> sqlSongs;
    private Set <String> apiSongs;
    private String successMessage;
    @AfterMethod
    public void deletePlaylist() {
        token = Token.getToken(email, password, url);
        given().baseUri(url + "/api/playlist/" + playlistId)
                .header("Authorization", "Bearer " + token)
                .when().delete()
                .then().statusCode(200);
        System.out.println("Playlist deleted");
    }
    @Test (dataProvider = "createSP_OneRule_DefaultValues", dataProviderClass = TestData.class)
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

    @Test (dataProvider = "createSP_OneRule", dataProviderClass = TestData.class)
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
}
//        System.out.println("sqlSongs");
//        System.out.println(sqlSongs);
//        System.out.println("apiSongs");
//        System.out.println(apiSongs);