package pageObjectTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPageSpare;
import pageObjects.MainPage;

public class PlaylistTests extends BaseTest {
    Integer playlistId;
    //    String playlistName = RandomStringUtils.randomAlphabetic(10);
    @Test
    public void createPlaylist() {
        String playlistName = faker.job().title();
        LoginPageSpare loginPage = new LoginPageSpare(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(email,password);
        playlistId = mainPage.addPlaylist(playlistName);
        Assert.assertTrue(mainPage.playlistExist(playlistId,playlistName));
    }
    @Test
    public void deletePlaylist() {
        LoginPageSpare loginPage = new LoginPageSpare(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(email,password);
        mainPage.deletePlaylist(playlistId);
        Assert.assertFalse(mainPage.playlistExist(playlistId));
    }


}
