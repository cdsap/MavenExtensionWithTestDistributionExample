package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathService - fibonacci")
class FibonacciTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "10, 55", "15, 610"})
    void computesFibonacci(int index, int expected) {
        assertEquals(expected, mathService.fibonacci(index));
    }

    @Test
    void throwsForNegativeIndex() {
        assertThrows(IllegalArgumentException.class, () -> mathService.fibonacci(-1));
    }
}
