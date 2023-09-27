package adapter_my;


import models.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queries extends DbAdapter{
    public Queries() {
        super();
    }

    public static List<Song> getSons() throws SQLException {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT * from songs s";
        ResultSet resultSet = DbAdapter.makeQuery(query);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            int album = resultSet.getInt("album_id");
            int artist = resultSet.getInt("artist_id");
            String title = resultSet.getString("title");
            Song song = new Song(id, album, artist, title);
            songs.add(song);
        }
        return songs;
    }
    public static List<String> getSongsInPlaylist(int playlistId) throws SQLException {
        List<String> songs = new ArrayList<>();
        String query = "SELECT playlist_id, s.title FROM playlist_song ps\n" +
                "JOIN songs s \n" +
                "on ps.song_id =s.id \n" +
                "WHERE playlist_id =" + playlistId;
        ResultSet resultSet = DbAdapter.makeQuery(query);
        while (resultSet.next()) {
            String songTitle = resultSet.getString("title");
            songs.add(songTitle);
        }
        return songs;
    }
}



