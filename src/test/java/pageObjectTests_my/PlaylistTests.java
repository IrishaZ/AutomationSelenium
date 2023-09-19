package pageObjectTests_my;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects_my.LoginPage;
import pageObjects_my.MainPage;

public class PlaylistTests extends BaseTest {
    Integer playlistId;
    //    String playlistName = RandomStringUtils.randomAlphabetic(10);
    @Test
    public void createPlaylist() {
        String playlistName = faker.job().title();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(email,password);
        playlistId = mainPage.addPlaylist(playlistName);
        Assert.assertTrue(mainPage.playlistExist(playlistId,playlistName));
    }
    @Test
    public void renamePlaylist() {
        String newPlaylistName = faker.job().title();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(email,password);
        try {
            mainPage.renamePlaylist(playlistId,newPlaylistName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(mainPage.playlistExist(playlistId,newPlaylistName));
    }
    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(url);
        MainPage mainPage =loginPage.loginToApp(email,password);
        mainPage.deletePlaylist(playlistId);
        Assert.assertFalse(mainPage.playlistExist(playlistId));
    }

}
