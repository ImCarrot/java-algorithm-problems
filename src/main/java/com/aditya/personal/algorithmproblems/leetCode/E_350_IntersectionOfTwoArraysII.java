package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E_350_IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> cache = new HashMap<>();

        for(Integer number: nums1)
            cache.put(number, cache.getOrDefault(number, 0) + 1);

        List<Integer> matches = new ArrayList<>();
        for(int number: nums2) {
            if(cache.containsKey(number) && cache.get(number) > 0) {
                cache.put(number, cache.get(number) - 1);
                matches.add(number);
            }
        }

        int[] toReturn = new int[matches.size()];
        int pointer = 0;

        for (int number: matches)
            toReturn[pointer++] = number;

        return toReturn;
    }

}
