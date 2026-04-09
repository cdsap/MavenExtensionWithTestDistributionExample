package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CollectionUtils - removeDuplicates")
class CollectionUtilsTest {

    @Test
    void removesDuplicateIntegers() {
        assertEquals(List.of(1, 2, 3), CollectionUtils.removeDuplicates(List.of(1, 2, 2, 3, 3, 3)));
    }

    @Test
    void removesDuplicateStrings() {
        assertEquals(List.of("a", "b", "c"), CollectionUtils.removeDuplicates(List.of("a", "b", "a", "c", "b")));
    }

    @Test
    void preservesOrderAfterDedup() {
        assertEquals(List.of(3, 1, 2), CollectionUtils.removeDuplicates(List.of(3, 1, 2, 1, 3)));
    }

    @Test
    void returnsEmptyListForNull() {
        assertTrue(CollectionUtils.removeDuplicates(null).isEmpty());
    }

    @Test
    void handlesEmptyList() {
        assertTrue(CollectionUtils.removeDuplicates(List.of()).isEmpty());
    }

    @Test
    void handlesListWithNoDuplicates() {
        assertEquals(List.of(1, 2, 3), CollectionUtils.removeDuplicates(List.of(1, 2, 3)));
    }
}
