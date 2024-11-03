package User;

public class UserService {
    public User registerUser(String email, String password) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        User user = new User(email, password);
        user.setActive(true);
        return user;
    }
}
