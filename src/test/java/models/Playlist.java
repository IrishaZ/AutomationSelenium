package models;

import java.util.List;
import java.util.Objects;

public class Playlist {
    private int id;
    private String name;
    private List<Objects> rules;
    private Boolean is_smart;

    public Playlist(int id, String name, List<Objects> rules, Boolean is_smart) {
        this.id = id;
        this.name = name;
        this.rules = rules;
        this.is_smart = is_smart;
    }
    public Playlist() { }

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

    public List<Objects> getRules() {
        return rules;
    }

    public void setRules(List<Objects> rules) {
        this.rules = rules;
    }

    public Boolean getIs_smart() {
        return is_smart;
    }

    public void setIs_smart(Boolean is_smart) {
        this.is_smart = is_smart;
    }
}
