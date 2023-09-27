package models_my;

public class PlaylistRequest {
        private String name;
//        private String[] rules;

    public PlaylistRequest(String name) {
        this.name = name;
    }
    public PlaylistRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
