package com.example.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public User createUser(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (findByEmail(email).isPresent()) {
            throw new IllegalStateException("User with email " + email + " already exists");
        }
        User user = new User(users.size() + 1L, name, email);
        users.add(user);
        return user;
    }

    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(u -> u.email().equals(email))
                .findFirst();
    }

    public Optional<User> findById(long id) {
        return users.stream()
                .filter(u -> u.id() == id)
                .findFirst();
    }

    public List<User> findAll() {
        return List.copyOf(users);
    }

    public boolean deleteUser(long id) {
        return users.removeIf(u -> u.id() == id);
    }

    public record User(long id, String name, String email) {}
}
