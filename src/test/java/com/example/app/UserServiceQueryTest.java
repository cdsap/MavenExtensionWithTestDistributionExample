package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService - queries and delete")
class UserServiceQueryTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void findsByEmail() {
        userService.createUser("Alice", "alice@example.com");
        Optional<UserService.User> found = userService.findByEmail("alice@example.com");

        assertTrue(found.isPresent());
        assertEquals("Alice", found.get().name());
    }

    @Test
    void returnsEmptyForNonExistentEmail() {
        assertTrue(userService.findByEmail("nobody@example.com").isEmpty());
    }

    @Test
    void findsById() {
        UserService.User created = userService.createUser("Alice", "alice@example.com");
        Optional<UserService.User> found = userService.findById(created.id());

        assertTrue(found.isPresent());
        assertEquals("Alice", found.get().name());
    }

    @Test
    void returnsEmptyForNonExistentId() {
        assertTrue(userService.findById(999).isEmpty());
    }

    @Test
    void returnsEmptyListWhenNoUsers() {
        assertTrue(userService.findAll().isEmpty());
    }

    @Test
    void returnsAllUsers() {
        userService.createUser("Alice", "alice@example.com");
        userService.createUser("Bob", "bob@example.com");

        assertEquals(2, userService.findAll().size());
    }

    @Test
    void deletesExistingUser() {
        UserService.User user = userService.createUser("Alice", "alice@example.com");
        assertTrue(userService.deleteUser(user.id()));
        assertTrue(userService.findById(user.id()).isEmpty());
    }

    @Test
    void returnsFalseForDeletingNonExistentUser() {
        assertFalse(userService.deleteUser(999));
    }
}
