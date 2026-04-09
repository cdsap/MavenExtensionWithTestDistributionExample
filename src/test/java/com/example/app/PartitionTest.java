package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CollectionUtils - partition")
class PartitionTest {

    @Test
    void partitionsEvenList() {
        List<List<Integer>> result = CollectionUtils.partition(List.of(1, 2, 3, 4), 2);
        assertEquals(2, result.size());
        assertEquals(List.of(1, 2), result.get(0));
        assertEquals(List.of(3, 4), result.get(1));
    }

    @Test
    void partitionsWithRemainder() {
        List<List<Integer>> result = CollectionUtils.partition(List.of(1, 2, 3, 4, 5), 2);
        assertEquals(3, result.size());
        assertEquals(List.of(5), result.get(2));
    }

    @Test
    void partitionsSizeOne() {
        assertEquals(3, CollectionUtils.partition(List.of(1, 2, 3), 1).size());
    }

    @Test
    void partitionSizeLargerThanList() {
        List<List<Integer>> result = CollectionUtils.partition(List.of(1, 2), 10);
        assertEquals(1, result.size());
        assertEquals(List.of(1, 2), result.get(0));
    }

    @Test
    void throwsForNullList() {
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.partition(null, 2));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    void throwsForNonPositiveSize(int size) {
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.partition(List.of(1), size));
    }
}
