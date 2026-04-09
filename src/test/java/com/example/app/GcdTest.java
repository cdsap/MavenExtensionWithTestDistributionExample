package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathService - gcd")
class GcdTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @ParameterizedTest
    @CsvSource({"12, 8, 4", "100, 75, 25", "7, 13, 1", "0, 5, 5", "48, 18, 6"})
    void computesGcd(int a, int b, int expected) {
        assertEquals(expected, mathService.gcd(a, b));
    }

    @Test
    void handlesNegativeNumbers() {
        assertEquals(6, mathService.gcd(-12, 18));
    }
}
