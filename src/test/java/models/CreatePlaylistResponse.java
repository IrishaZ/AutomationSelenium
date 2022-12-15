package models;

public class CreatePlaylistResponse {
    private int id;
    private String name;

    public CreatePlaylistResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CreatePlaylistResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

