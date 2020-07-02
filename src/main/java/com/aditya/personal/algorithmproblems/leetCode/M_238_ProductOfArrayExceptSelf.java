package com.aditya.personal.algorithmproblems.leetCode;

public class M_238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int currentMul = 1;

        int[] left = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            currentMul *= nums[i];
            left[i] = currentMul;
        }

        currentMul = 1;
        int[] right = new int[nums.length];

        for (int i = nums.length -1; i >=0; i--) {
            currentMul *= nums[i];
            right[i] = currentMul;
        }

        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int leftMul = i > 0 ? left[i - 1] : 1;
            int rightMul = i < nums.length - 1 ? right[i + 1] : 1;
            output[i] = leftMul * rightMul;
        }

        return output;
    }

}
