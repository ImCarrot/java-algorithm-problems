package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;

public class E_1_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> visited = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            if (visited.containsKey(nums[i]))
                return new int[]{visited.get(nums[i]), i};

            visited.put(target - nums[i], i);
        }
        return null;
    }
}
