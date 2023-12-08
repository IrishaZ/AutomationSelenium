package pageObjectTests;
import api.Api;
import helper.Token;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

public class LogOut extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    AllSongsPage allSongsPage;
    AlbumPage albumPage;
    ArtistPage artistPage;
    CurrentQueuePage currentQueuePage;
    FavoritesPage favoritesPage;
    RecentlyPlayedPage recentlyPlayedPage;
    ProfilePage profilePage;

    @BeforeMethod
    public void beforeAll(){
        mainPage= login();
    }
    @Test
    public void logOutHomePage() {
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());
    }
    @Test
    public void logOutCurrentQueuePage() {
        CurrentQueuePage currentQueuePage=mainPage.openCurrentQueuePage();
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());
    }
    @Test
    public void logOutAllSongsPage() {
        allSongsPage=mainPage.openAllSongPage();
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());
    }
    @Test
    public void logOutAlbumPage() {
        albumPage=mainPage.openAlbumPage();
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());
    }
    @Test
    public void logOutArtistPage() {
        artistPage=mainPage.openArtistPage();
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());
    }
    @Test
    public void logOutFavoritesPage() {
        favoritesPage=mainPage.openFavoritesPage();
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());
    }
    @Test
    public void logOutRecentlyPlayedPage() {
        recentlyPlayedPage=mainPage.openRecentlyPlayedPage();
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());
    }
    @Test
    public void logOutProfilePage() {
        profilePage=mainPage.openProfilePage();
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());
    }
    @Test
    public void logOutAfterEmailUpdate() throws InterruptedException {
        String newEmail="new"+email;
        profilePage =mainPage.openProfilePage();
        profilePage.credentialsUpdate(password,newEmail,password);
        Thread.sleep(7000);
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());

        String newToken= Token.getToken(newEmail,password ,url);
        Api.updateUser(url,newToken,"student",email,password,password);
    }
    @Test
    public void logOutAfterPasswordUpdate() throws InterruptedException {
        String newPassword="new"+password;
        profilePage =mainPage.openProfilePage();
        profilePage.credentialsUpdate(password,email,newPassword);
        Thread.sleep(7000);
        LoginPage loginPage = logOut();
        Assert.assertTrue(loginPage.isOpen());

        String newToken= Token.getToken(email,newPassword ,url);
        Api.updateUser(url,newToken,"student",email,newPassword,password);
        System.out.println("Email is back");
    }


}