package models;

public class SongInfo {
    private String songId;
    private String songTitle;
    private String lyrics;

    private String album;
    private String artist;

    public SongInfo(String songId, String songTitle, String lyrics, String album, String artist) {
        this.songId = songId;
        this.songTitle = songTitle;
        this.lyrics = lyrics;
        this.album = album;
        this.artist = artist;
    }
    public SongInfo() {}

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "SongInfo{" +
                "songId='" + this.songId + '\'' +
                ", songTitle='" + this.songTitle + '\'' +
                ", lyrics='" + this.lyrics + '\'' +
                ", album='" + this.album + '\'' +
                ", artist='" + this.artist + '\'' +
                '}';
    }
}
