package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.*;

public class KOccurrencesGivenArray {

    public static List<Integer> kNumberOccurrencesGivenArray(int[] numbers, int k) {

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : numbers)
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);

        if (k > frequencies.size())
            throw new IllegalArgumentException("k must be greater than the number of unique numbers.");

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {

            int comparisonResult = frequencies.get(b).compareTo(frequencies.get(a));

            if (comparisonResult != 0)
                return comparisonResult;

            return Integer.compare(b, a);
        });

        maxHeap.addAll(frequencies.keySet());

        List<Integer> output = new ArrayList<>();
        while (k > 0 && !maxHeap.isEmpty()) {
            output.add(maxHeap.poll());
            k--;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(kNumberOccurrencesGivenArray(new int[] {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}, 4));
    }

}
