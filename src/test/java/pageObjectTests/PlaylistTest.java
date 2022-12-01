package pageObjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class PlaylistTest extends BaseTest{

    @Test
    public void createPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username,password);

//        String playlistName = RandomStringUtils.randomAlphabetic(10);
        String playlistName = faker.job().title();
        System.out.println(playlistName);
        int playlistId = mainPage.createPlaylist(playlistName);
        Assert.assertTrue(mainPage.playlistExist(playlistId,playlistName));
    }

    @Test
    public void renamePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username,password);
        String playlistName = faker.job().title();
        int playlistId = mainPage.createPlaylist(playlistName);

        String newName = faker.artist().name();
        mainPage.renamePlaylist(playlistId,newName);

        Assert.assertTrue(mainPage.playlistExist(playlistId,newName));
    }
    @Test
    public void createPlaylist1(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username,password);

//        String playlistName = RandomStringUtils.randomAlphabetic(10);
        String playlistName = faker.job().title();
        System.out.println(playlistName);
        int playlistId = mainPage.createPlaylist(playlistName);
        Assert.assertTrue(mainPage.playlistExist(playlistId,playlistName));
    }

    @Test
    public void renamePlaylist1(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username,password);
        String playlistName = faker.job().title();
        int playlistId = mainPage.createPlaylist(playlistName);

        String newName = faker.artist().name();
        mainPage.renamePlaylist(playlistId,newName);

        Assert.assertTrue(mainPage.playlistExist(playlistId,newName));
    }
    @Test
    public void createPlaylist2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username,password);

//        String playlistName = RandomStringUtils.randomAlphabetic(10);
        String playlistName = faker.job().title();
        System.out.println(playlistName);
        int playlistId = mainPage.createPlaylist(playlistName);
        Assert.assertTrue(mainPage.playlistExist(playlistId,playlistName));
    }

    @Test
    public void renamePlaylist2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username,password);
        String playlistName = faker.job().title();
        int playlistId = mainPage.createPlaylist(playlistName);

        String newName = faker.artist().name();
        mainPage.renamePlaylist(playlistId,newName);

        Assert.assertTrue(mainPage.playlistExist(playlistId,newName));
    }
    @Test(enabled = false)
    public void createPlaylist3(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username,password);

//        String playlistName = RandomStringUtils.randomAlphabetic(10);
        String playlistName = faker.job().title();
        System.out.println(playlistName);
        int playlistId = mainPage.createPlaylist(playlistName);
        Assert.assertTrue(mainPage.playlistExist(playlistId,playlistName));
    }

    @Test
    public void renamePlaylist3(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username,password);
        String playlistName = faker.job().title();
        int playlistId = mainPage.createPlaylist(playlistName);

        String newName = faker.artist().name();
        mainPage.renamePlaylist(playlistId,newName);

        Assert.assertTrue(mainPage.playlistExist(playlistId,newName));
    }
}
