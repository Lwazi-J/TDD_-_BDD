package User;

public class User {
    private String email;
    private String password;
    private boolean isActive;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.isActive = false;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
