package dbTest;

import sql.Queries;
import models.Song;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static sql.Queries.getAllSongs;

public class QueryTests {
    @Test
    public void getSongsMy() throws SQLException {
        List<Song> list  = getAllSongs();
        for (Song song: list){
            System.out.println(song.getId());
        }
    }
    @Test
    public void getPlaylistSongs() throws SQLException {
        List<String> list  = Queries.getSongsTitlesInPlaylist(67222);
        System.out.println(list);
        System.out.println(list.contains("Take my Hand (ID 1696) "));
    }
}
