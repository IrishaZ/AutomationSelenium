package pageObjectTests;

import listener.RetryAnalyzer;
import models.SongInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AlbumPage;
import pageObjects.AllSongsPage;
import pageObjects.CurrentQueuePage;
import pageObjects.MainPage;
import sql.Queries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoPanel extends BaseTest {
    MainPage mainPage;
    String songTitle = "Pluto";
    SongInfo songInfo;
    AllSongsPage allSongsPage;
    AlbumPage albumPage;
    CurrentQueuePage currentQueuePage;

    @BeforeTest
    public SongInfo sqlGetSongInfo() throws SQLException {
        return songInfo = Queries.getSongInfo(songTitle);
    }

    @Test(retryAnalyzer= RetryAnalyzer.class)
    public void albumInfoIsDisplayedCorrectly() {
        mainPage = login();
        allSongsPage = mainPage.openAllSongPage();
        allSongsPage.openAlbumTab();
        allSongsPage.playSong(songTitle);
        Assert.assertEquals(allSongsPage.getAlbumNameFromInfoPanel(), songInfo.getAlbum());
    }

    @Test
    public void artistInfoIsDisplayedCorrectly() {
        mainPage = login();
        allSongsPage = mainPage.openAllSongPage();
        allSongsPage.openArtistTab();
        allSongsPage.playSong(songTitle);
        Assert.assertEquals(mainPage.getArtistNameFromInfoPanel(), songInfo.getArtist());
    }

    @Test
    public void lyricInfoIsDisplayedCorrectly() {
        mainPage = login();
        allSongsPage = mainPage.openAllSongPage();
        allSongsPage.openLyricTab();
        allSongsPage.playSong(songTitle);
        Assert.assertEquals(mainPage.getLyricFromInfoPanel(), songInfo.getLyrics());
    }

    @Test
    public void infoButtonClosesInfoPanel() {
        mainPage = login();
        mainPage.closeInfoPanel();
        Assert.assertTrue(mainPage.infoPanelIsHidden());
    }

    @Test
    public void infoButtonOpensInfoPanel() {
        mainPage = login();
        mainPage.closeInfoPanel();

        mainPage.openInfoPanel();
        Assert.assertTrue(mainPage.infoPanelIsDisplayed());
    }
    @Test()
    public void shuffleButtonAlbumTabShuffleAlbumSongs() {
        mainPage = login();
        albumPage = mainPage.openAlbumPage();
        currentQueuePage=albumPage.openAlbumAirbitOrByName("Onomatopoeia");
        currentQueuePage.openAlbumTab();
        ArrayList<String> albumSongs=currentQueuePage.getAllSongs();

        currentQueuePage.clickShuffleButtonAlbumTab();

        ArrayList<String> albumSongsAfterShuffle=currentQueuePage.getAllSongs();
        if (albumSongsAfterShuffle.size()!=1) {
            Assert.assertNotEquals(albumSongsAfterShuffle, albumSongs);
        } else {
            Assert.assertEquals(albumSongsAfterShuffle, albumSongs);}
    }
    @Test()
    public void shuffleButtonArtistTabShuffleAlbumSongs() {
        mainPage = login();
        albumPage = mainPage.openAlbumPage();
        currentQueuePage=albumPage.openAlbumAirbitOrByName("Onomatopoeia");
        currentQueuePage.openArtistTab();
        ArrayList<String> albumSongs=currentQueuePage.getAllSongs();

        currentQueuePage.clickShuffleButtonArtistTab();

        ArrayList<String> albumSongsAfterShuffle=currentQueuePage.getAllSongs();
        System.out.println(albumSongsAfterShuffle);
        if (albumSongsAfterShuffle.size()!=1) {
            Assert.assertNotEquals(albumSongsAfterShuffle, albumSongs);
        } else {
            Assert.assertEquals(albumSongsAfterShuffle, albumSongs);}
    }
}

