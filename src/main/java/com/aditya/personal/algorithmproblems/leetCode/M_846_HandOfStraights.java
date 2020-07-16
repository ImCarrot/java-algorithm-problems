package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M_846_HandOfStraights {

    public boolean isNStraightHand(int[] nums, int k) {
        if (nums.length < k)
            return false;

        Arrays.sort(nums);

        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int number: nums)
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);

        for (int num : nums) {

            if (frequencies.get(num) == 0)
                continue;

            int current = num;
            int toMatch = k;
            while (toMatch != 0 && frequencies.getOrDefault(current, 0) > 0) {
                frequencies.put(current, frequencies.get(current) - 1);
                current = current + 1;
                toMatch--;
            }

            if (toMatch != 0)
                return false;
        }

        return true;
    }

}
