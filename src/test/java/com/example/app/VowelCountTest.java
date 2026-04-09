package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringUtils - countVowels")
class VowelCountTest {

    @ParameterizedTest
    @CsvSource({
            "hello, 2",
            "world, 1",
            "aeiou, 5",
            "AEIOU, 5",
            "rhythm, 0",
            "banana, 3"
    })
    void countsVowelsCorrectly(String input, int expected) {
        assertEquals(expected, StringUtils.countVowels(input));
    }

    @Test
    void returnsZeroForNull() {
        assertEquals(0, StringUtils.countVowels(null));
    }

    @Test
    void returnsZeroForEmptyString() {
        assertEquals(0, StringUtils.countVowels(""));
    }
}
