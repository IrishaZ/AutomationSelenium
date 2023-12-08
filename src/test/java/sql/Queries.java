package sql;


import models.Song;

import java.sql.*;
import java.util.*;

public class Queries extends DbAdapter{
    public Queries() {
        super();
    }

    public static List<Song> getAllSongs() throws SQLException {
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
    public static List<String> getSongsTitlesInPlaylist(int playlistId) throws SQLException {
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
    public static Set<String> getSongsIdByCriteria(String query) throws SQLException {
        Set<String> songsId= new HashSet<>();
        ResultSet resultSet = DbAdapter.makeQuery(query);
        while (resultSet.next()) {
            String songId = resultSet.getString("id");
            songsId.add(songId);
        }
        return songsId;
    }
    public static String getPlaylistNameById(int playlistId) throws SQLException {
        String playlistName = null;
        String query = "SELECT name  FROM playlists p WHERE p.id =" + playlistId;
        ResultSet resultSet = DbAdapter.makeQuery(query);
        while (resultSet.next()) {
            playlistName = resultSet.getString("name");
        }
        return playlistName;
    }
    public static int getPlaylistIdByName(String playlistName) throws SQLException {
        int playlistId = 0;
        String query = "SELECT p.id FROM playlists p WHERE p.name LIKE '"+playlistName+"'";
        ResultSet resultSet = DbAdapter.makeQuery(query);
        while (resultSet.next()) {
            playlistId = resultSet.getInt("id");
        }
        return playlistId;
    }
    public static int getUserId(String email) throws SQLException {
        int userId=0;
        String query ="SELECT id from dbkoel.users u where email='"+email+"'";
        ResultSet resultSet = DbAdapter.makeQuery(query);
        while (resultSet.next()) {
            userId = resultSet.getInt("id");
        }
        return userId;
    }
    public static List<Integer> getUserPlaylists(int userId) throws SQLException {
        List<Integer> playlistsId=new ArrayList<>();
        String query ="SELECT * FROM dbkoel.playlists p WHERE user_id ='"+userId+"'";
        ResultSet resultSet = DbAdapter.makeQuery(query);
        while (resultSet.next()) {
            playlistsId.add(resultSet.getInt("id"));
        }
        return playlistsId;
    }
}
//    public static Set<String> getSongsIdByAlbumContains(String name) throws SQLException {
//        Set<String> songsId= new HashSet<>();
//        String query = "SELECT s.id FROM songs s JOIN albums a ON s.album_id =a.id WHERE a.name LIKE '%"+ name+"%'";
//        ResultSet resultSet = DbAdapter.makeQuery(query);
//        while (resultSet.next()) {
//            String songId = resultSet.getString("id");
//            songsId.add(songId);
//        }
//        return songsId;
//    }


