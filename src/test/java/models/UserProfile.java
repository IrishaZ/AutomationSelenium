package models;

public class UserProfile extends Credentials {
    private String name;
    private String email;
    private String current_password;
    private String new_password;

    public UserProfile(String name, String email, String current_password, String new_password) {
        super(email,current_password);
        this.new_password = new_password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrent_password() {
        return current_password;
    }

    public void setCurrent_password(String current_password) {
        this.current_password = current_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
}
