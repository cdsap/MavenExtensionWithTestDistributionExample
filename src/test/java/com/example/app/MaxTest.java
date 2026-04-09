package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CollectionUtils - max")
class MaxTest {

    @Test
    void findsMaxInteger() {
        assertEquals(5, CollectionUtils.max(List.of(1, 5, 3, 2, 4)));
    }

    @Test
    void findsMaxString() {
        assertEquals("z", CollectionUtils.max(List.of("a", "z", "m")));
    }

    @Test
    void findsMaxWithSingleElement() {
        assertEquals(42, CollectionUtils.max(List.of(42)));
    }

    @Test
    void throwsForEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.<Integer>max(List.of()));
    }

    @Test
    void throwsForNullList() {
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.max(null));
    }

    @Test
    void findsMaxWithNegativeNumbers() {
        assertEquals(-1, CollectionUtils.max(List.of(-5, -3, -1, -10)));
    }
}
