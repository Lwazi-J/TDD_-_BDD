package User;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = new UserService();

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    public void shouldCreateUserWithValidEmailAndPassword() {
        // Given
        String email = "test@example.com";
        String password = "password123";

        // When
        User user = userService.registerUser(email, password);

        // Then
        assertNotNull(user);
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertTrue(user.isActive());
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsEmpty() {
        // Given
        String email = "";
        String password = "password123";

        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> userService.registerUser(email, password));
    }

    @Test
    public void shouldThrowExceptionWhenPasswordIsTooShort() {
        // Given
        String email = "test@example.com";
        String password = "short";

        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> userService.registerUser(email, password));
    }
}
