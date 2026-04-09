package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathService - average")
class AverageTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @Test
    void computesAverageOfList() {
        assertEquals(3.0, mathService.average(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void computesAverageOfSingleElement() {
        assertEquals(42.0, mathService.average(List.of(42)));
    }

    @Test
    void throwsForEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> mathService.average(List.of()));
    }

    @Test
    void throwsForNull() {
        assertThrows(IllegalArgumentException.class, () -> mathService.average(null));
    }
}
