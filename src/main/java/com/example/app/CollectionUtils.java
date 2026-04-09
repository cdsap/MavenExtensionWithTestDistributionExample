package com.example.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionUtils {

    public static <T> List<T> removeDuplicates(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> List<List<T>> partition(List<T> list, int size) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Partition size must be positive");
        }
        List<List<T>> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i += size) {
            partitions.add(list.subList(i, Math.min(i + size, list.size())));
        }
        return partitions;
    }

    public static <T> Map<T, Integer> frequency(List<T> list) {
        if (list == null) {
            return Collections.emptyMap();
        }
        Map<T, Integer> freq = new HashMap<>();
        for (T item : list) {
            freq.merge(item, 1, Integer::sum);
        }
        return freq;
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty");
        }
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }
}
