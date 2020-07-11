package com.aditya.personal.algorithmproblems.leetCode;

import java.util.*;

public class M_18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> matches = new ArrayList<>();

        if (nums.length < 4)
            return matches;

        for (int i = 0; i < nums.length; i++) {

            int remaining = target - nums[i];

            int[] found = threeSum(nums, remaining, i + 1);

            if (found != null)
                matches.add(Arrays.asList(nums[i], found[0], found[1], found[2]));

        }

        return matches;
    }

    private int[] threeSum(int[] nums, int target, int start) {

        for (int i = start; i < nums.length; i++) {

            int remaining = target - nums[i];

            int[] found = twoSum(nums, remaining, i + 1);

            if (found != null)
                return new int[]{nums[i], found[0], found[1]};

        }
        return null;
    }

    private int[] twoSum(int[] nums, int target, int start) {

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = start; i < nums.length; i++) {

            if (seen.containsKey(nums[i]))
                return new int[]{nums[i], nums[seen.get(nums[i])]};

            seen.put(target - nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        M_18_4Sum instance = new M_18_4Sum();
        System.out.println(instance.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
