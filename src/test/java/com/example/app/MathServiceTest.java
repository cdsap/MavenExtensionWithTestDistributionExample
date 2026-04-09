package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathService - factorial")
class MathServiceTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "3, 6", "4, 24", "5, 120", "10, 3628800"})
    void computesFactorial(int input, int expected) {
        assertEquals(expected, mathService.factorial(input));
    }

    @Test
    void throwsForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> mathService.factorial(-1));
    }
}
