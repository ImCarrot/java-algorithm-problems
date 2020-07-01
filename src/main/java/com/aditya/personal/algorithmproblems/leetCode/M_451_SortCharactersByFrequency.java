package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class M_451_SortCharactersByFrequency {

    public String frequencySort(String s) {

        if (s == null || s.trim().isEmpty())
            return s;

        Map<Character, Integer> freq = new HashMap<>();

        for (char c: s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(freq.get(b), freq.get(a)));

        maxHeap.addAll(freq.keySet());

        StringBuilder outputBuilder = new StringBuilder();

        while (!maxHeap.isEmpty()) {

            char c = maxHeap.poll();

            while (freq.get(c) > 0) {
                outputBuilder.append(c);
                freq.put(c, freq.get(c) - 1);
            }
        }

        return outputBuilder.toString();
    }
}
