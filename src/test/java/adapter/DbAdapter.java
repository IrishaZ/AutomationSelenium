package adapter;


import models.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAdapter {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://104.237.13.60/dbkoel";

    //  Database credentials
    private static final String USER = "dbuser01";
    private static final String PASS = "pa$$01";

    public static List<Song> getSons() {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT * from songs s";
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()){
                String id = resultSet.getString("id");
                int album = resultSet.getInt("album_id");
                int artist = resultSet.getInt("artist_id");
                String title = resultSet.getString("title");

                Song song = new Song(id,album,artist,title);
                songs.add(song);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {}// do nothing

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return songs;
    }//end main

    public static String getPlaylistName(int playlistId) {
       String name = null;
        String query = "select name FROM playlists p WHERE id="+playlistId;
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()){
                name=resultSet.getString("name");

            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {}// do nothing

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return name;
    }
}



