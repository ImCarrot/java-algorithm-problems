package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class M_347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        if (nums.length < k)
            return nums;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int number: nums)
            freq.put(number, freq.getOrDefault(number, 0) + 1);

        PriorityQueue<Integer> numbers = new PriorityQueue<>((a, b) -> Integer.compare(freq.get(b), freq.get(a)));

        numbers.addAll(freq.keySet());

        int[] toReturn = new int[k];
        int pointer = 0;
        while (k > 0 && !numbers.isEmpty()) {
            toReturn[pointer] = numbers.poll();
            pointer++;
            k--;
        }
        return toReturn;
    }

}
