package models_my;

public class Pet {
    public long id;
    public String name;
    public String[] photoUrls;
    public String status;
    public Category category;
    public Tag[] tags;

    public Pet(String name, String[] photoUrls, String status, Category category, Tag[] tags) {
        this.name = name;
        this.photoUrls = photoUrls;
        this.status = status;
        this.category = category;
        this.tags = tags;
    }

    public Pet() {
    }
}
