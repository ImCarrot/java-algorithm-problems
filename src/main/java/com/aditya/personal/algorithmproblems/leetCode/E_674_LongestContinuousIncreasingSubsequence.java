package com.aditya.personal.algorithmproblems.leetCode;

public class E_674_LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        int currentMax = 1;
        int current = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1])
                current += 1;
            else
                current = 1;

            currentMax = Math.max(currentMax, current);
        }
        return currentMax;
    }

}
