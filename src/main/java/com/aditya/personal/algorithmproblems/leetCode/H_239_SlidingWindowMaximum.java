package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class H_239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] leftMax = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            leftMax[i] = i % k == 0 ? nums[i] : Math.max(nums[i], leftMax[i - 1]);

        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--)
            rightMax[i] = i % k == 0 ? nums[i] : Math.max(nums[i], rightMax[i + 1]);


        int[] output = new int[nums.length - k + 1];

        for (int i = 0, j = 0; i + k <= nums.length; i++)
            output[j++] = Math.max(rightMax[i], leftMax[i + k - 1]);

        return output;
    }

    public static void main(String[] args) {
        H_239_SlidingWindowMaximum instance = new H_239_SlidingWindowMaximum();
        System.out.println(Arrays.toString(instance.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
