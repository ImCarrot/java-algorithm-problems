package com.aditya.personal.algorithmproblems.leetCode;

public class E_1464_MaximumProductOfTwoElementsInAnArray {

    public int maxProduct(int[] nums) {

        int maxValue = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num > maxValue) {
                secondMax = maxValue;
                maxValue = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return (maxValue - 1)*(secondMax - 1);
    }

}
