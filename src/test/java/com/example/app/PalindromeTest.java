package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringUtils - isPalindrome")
class PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "madam", "level", "A man a plan a canal Panama"})
    void detectsPalindromes(String input) {
        assertTrue(StringUtils.isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "java"})
    void detectsNonPalindromes(String input) {
        assertFalse(StringUtils.isPalindrome(input));
    }

    @Test
    void returnsFalseForNull() {
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    void emptyStringIsPalindrome() {
        assertTrue(StringUtils.isPalindrome(""));
    }
}
