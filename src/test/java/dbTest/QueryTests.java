package dbTest;

import adapter.Queries;
import models.Song;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static adapter.Queries.getSons;

public class QueryTests {
    @Test
    public void getSongsMy() throws SQLException {
        List<Song> list  = getSons();
        for (Song song: list){
            System.out.println(song.getId());
        }
    }
    @Test
    public void getPlaylistSongs() throws SQLException {
        List<String> list  = Queries.getSongsInPlaylist(67222);
        System.out.println(list);
        System.out.println(list.contains("Take my Hand (ID 1696) "));
    }
}
