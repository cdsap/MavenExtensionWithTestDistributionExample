package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CollectionUtils - frequency")
class FrequencyTest {

    @Test
    void countsFrequencies() {
        Map<String, Integer> freq = CollectionUtils.frequency(List.of("a", "b", "a", "c", "b", "a"));
        assertEquals(3, freq.get("a"));
        assertEquals(2, freq.get("b"));
        assertEquals(1, freq.get("c"));
    }

    @Test
    void returnsEmptyMapForNull() {
        assertTrue(CollectionUtils.frequency(null).isEmpty());
    }

    @Test
    void returnsEmptyMapForEmptyList() {
        assertTrue(CollectionUtils.frequency(List.of()).isEmpty());
    }
}
