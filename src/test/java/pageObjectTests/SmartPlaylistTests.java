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
        import java.sql.SQLException;
        import static io.restassured.RestAssured.given;

public class SmartPlaylistTests extends BaseTest {
    private String playlistName;
    private int playlistId;

    @Test
    public void createNewSmartPlaylist() throws InterruptedException, SQLException {
        playlistName = faker.funnyName().name();
        MainPage mainPage = login();
        mainPage.createSmartPlaylistOneRuleText(playlistName, FirstDropdown.ALBUM, SecondDropdown.CONTAINS, "Unknown");
        playlistId = Queries.getPlaylistIdByName(playlistName);
        Assert.assertEquals("Created playlist \"" + playlistName + ".\"", mainPage.getSuccessBanner().getText());
        Assert.assertEquals( Queries.getSongsIdByAlbumContains("Unknown"), Api.getPlaylistSongs(playlistId,token,url));    }

    @AfterMethod
    public void deletePlaylist() {
        token = Token.getToken(email, password, url);
        given().baseUri(url + "/api/playlist/" + playlistId)
                .header("Authorization", "Bearer " + token)
                .when().delete()
                .then().statusCode(200);
        System.out.println("Playlist deleted");
    }

}
