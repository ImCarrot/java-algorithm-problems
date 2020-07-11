package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class E_53_MaximumSubarray {

    public int maxSubArray(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int currentMax = sums[0];

        for (int i = 1; i < nums.length; i++) {

            sums[i] = Math.max(sums[i-1] + nums[i], nums[i]);
            currentMax = Math.max(currentMax, sums[i]);
        }
        return currentMax;
    }

}
