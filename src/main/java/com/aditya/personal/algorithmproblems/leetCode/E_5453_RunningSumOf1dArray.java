package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class E_5453_RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {

        int[] sumArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                sumArray[i] = nums[i];
                continue;
            }

            sumArray[i] = sumArray[i - 1] + nums[i];
        }
        return sumArray;

    }

    public static void main(String[] args) {
        E_5453_RunningSumOf1dArray instance = new E_5453_RunningSumOf1dArray();
        System.out.println(Arrays.toString(instance.runningSum(new int[]{1, 2, 3, 4})));
    }
}
