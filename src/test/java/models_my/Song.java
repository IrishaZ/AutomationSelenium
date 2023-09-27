package models_my;

public class Song {
    private String id;
    private int albumId;
    private int artistId;
    private String title;
    public Song(String id, int albumId, int artistId, String title) {
        this.id = id;
        this.albumId = albumId;
        this.artistId = artistId;
        this.title = title;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
