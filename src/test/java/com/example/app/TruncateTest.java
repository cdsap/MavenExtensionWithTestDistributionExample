package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringUtils - truncate")
class TruncateTest {

    @Test
    void truncatesLongString() {
        assertEquals("hel...", StringUtils.truncate("hello world", 3));
    }

    @Test
    void doesNotTruncateShortString() {
        assertEquals("hi", StringUtils.truncate("hi", 10));
    }

    @Test
    void returnsNullForNullInput() {
        assertNull(StringUtils.truncate(null, 5));
    }

    @Test
    void truncatesAtExactLength() {
        assertEquals("hello", StringUtils.truncate("hello", 5));
    }
}
