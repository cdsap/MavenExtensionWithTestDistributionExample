package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringUtils - reverse")
class StringUtilsTest {

    @Test
    void reversesSimpleString() {
        assertEquals("olleh", StringUtils.reverse("hello"));
    }

    @Test
    void reversesSingleCharacter() {
        assertEquals("a", StringUtils.reverse("a"));
    }

    @Test
    void reversesEmptyString() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    void returnsNullForNullInput() {
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void reversesStringWithSpaces() {
        assertEquals("dlrow olleh", StringUtils.reverse("hello world"));
    }
}
