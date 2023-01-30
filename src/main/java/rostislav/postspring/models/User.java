package rostislav.postspring.models;

public class User {
    public int id;
    public String username;
    public String email;
    public String password;
    public int salt;
    public String role;

    public User() {

    }

    public User(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
