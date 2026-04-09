package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathService - isPrime")
class PrimeTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 97})
    void identifiesPrimeNumbers(int n) {
        assertTrue(mathService.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 4, 6, 8, 9, 10, 15, 21, 100})
    void identifiesNonPrimeNumbers(int n) {
        assertFalse(mathService.isPrime(n));
    }
}
