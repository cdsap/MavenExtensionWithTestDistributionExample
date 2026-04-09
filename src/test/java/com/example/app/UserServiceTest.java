package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService - createUser")
class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void createsUserSuccessfully() {
        UserService.User user = userService.createUser("Alice", "alice@example.com");

        assertNotNull(user);
        assertEquals("Alice", user.name());
        assertEquals("alice@example.com", user.email());
        assertTrue(user.id() > 0);
    }

    @Test
    void throwsForBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser("", "test@example.com"));
    }

    @Test
    void throwsForNullName() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser(null, "test@example.com"));
    }

    @Test
    void throwsForInvalidEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser("Alice", "not-an-email"));
    }

    @Test
    void throwsForNullEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser("Alice", null));
    }

    @Test
    void throwsForDuplicateEmail() {
        userService.createUser("Alice", "alice@example.com");
        assertThrows(IllegalStateException.class,
                () -> userService.createUser("Bob", "alice@example.com"));
    }
}
