package dbTest;

import adapter.DbAdapter;
import models.Song;
import org.testng.annotations.Test;

import java.util.List;

public class GetSongs {
    @Test
    public void getSongs(){
        List<Song> list  = DbAdapter.getSons();
        for (Song song: list){
            System.out.println(song.getId());
        }

    }
}
