package com.aditya.personal.algorithmproblems.hackerrank.dictionaryAndHashMaps;

import java.util.*;

public class M_CountTriplets {

    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();

        boolean match = potential.values().stream().anyMatch(x-> x == 2);

        long count = 0;
        for (long number : arr) {

            long key = number / r;

            if (counter.containsKey(key) && number % r == 0) {
                count += counter.get(key);
            }

            if (potential.containsKey(key) && number % r == 0) {
                long c = potential.get(key);
                counter.put(number, counter.getOrDefault(number, 0L) + c);
            }

            potential.put(number, potential.getOrDefault(number, 0L) + 1);
        }
        return count;
    }

    static long countTriplets2(List<Long> arr, long r) {

        Map<Long, Long> right = new HashMap<>();
        Map<Long, Long> left = new HashMap<>();

        for(long number: arr)
            right.put(number, right.getOrDefault(number, 0L) + 1);

        int pairs = 0;

        for (long number: arr) {

            right.put(number, right.get(number) - 1);
            left.put(number, left.getOrDefault(number, 0L) + 1);

            long aByR = number % r == 0 ? number / r : 0;

            if (aByR == 0 || !left.containsKey(aByR))
                continue;

            long aTimesR = number * r;

            if (right.getOrDefault(aTimesR, 0L) < 1)
                continue;

            pairs += left.get(aByR) * right.get(aTimesR);
        }
        return pairs;
    }

    public static void main(String[] args) {

//        List<Long> input = Arrays.asList(1L, 1L, 1L, 1L);
        List<Long> input = Arrays.asList(1L, 5L, 5L, 25L, 125L);
        System.out.println(countTriplets(input, 5L));
    }

}
