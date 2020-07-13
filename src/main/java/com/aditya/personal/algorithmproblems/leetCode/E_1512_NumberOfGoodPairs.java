package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;

public class E_1512_NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {

        Map<Integer, Integer> valueCounts = new HashMap<>();

        int count = 0;
        for (int number: nums) {
            if (valueCounts.containsKey(number))
                count += valueCounts.get(number);

            valueCounts.put(number, valueCounts.getOrDefault(number, 0) + 1);
        }
        return count;
    }

}
