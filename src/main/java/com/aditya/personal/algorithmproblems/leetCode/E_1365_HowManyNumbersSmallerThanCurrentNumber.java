package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E_1365_HowManyNumbersSmallerThanCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        Map<Integer, Integer> numberIndexes = new HashMap<>();

        int[] sorted = nums.clone();

        Arrays.sort(sorted);

        for(int i = 0; i < sorted.length; i++) {
            if (!numberIndexes.containsKey(sorted[i]))
                numberIndexes.put(sorted[i], i);
        }

        for (int i = 0; i < nums.length; i ++) {
            nums[i] = numberIndexes.get(nums[i]);
        }
        return nums;
    }

}
