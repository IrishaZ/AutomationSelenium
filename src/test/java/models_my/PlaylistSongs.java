package models_my;

public class PlaylistSongs {
    private int playlistId;
    private String[]  songIds;

    public PlaylistSongs(int playlistId, String[] songIds) {
        this.playlistId = playlistId;
        this.songIds = songIds;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String[] getSongIds() {
        return songIds;
    }

    public void setSongIds(String[] songIds) {
        this.songIds = songIds;
    }
}

