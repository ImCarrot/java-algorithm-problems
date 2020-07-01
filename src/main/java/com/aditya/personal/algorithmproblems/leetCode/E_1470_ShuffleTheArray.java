package com.aditya.personal.algorithmproblems.leetCode;

public class E_1470_ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {


        int[] toReturn = new int[2*n];
        int returnPointer = 0;

        for (int i = 0; i < n; i++) {
            toReturn[returnPointer++] = nums[i];
            toReturn[returnPointer++] = nums[i + n];
        }
        return toReturn;
    }

}
