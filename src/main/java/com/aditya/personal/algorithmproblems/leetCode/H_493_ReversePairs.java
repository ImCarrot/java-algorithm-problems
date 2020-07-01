package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class H_493_ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] numbers, int start, int end) {

        if (start >= end)
            return 0;

        int mid = start + (end - start) / 2;

        int count = mergeSort(numbers, start, mid) + mergeSort(numbers, mid + 1, end);

        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && numbers[i] / 2.0 > numbers[j])
                j++;
            count += j - (mid + 1);
        }
        Arrays.sort(numbers, start, end + 1);

        return count;
    }


    public static void main(String[] args) {
        H_493_ReversePairs instance = new H_493_ReversePairs();
        System.out.println(instance.reversePairs(new int[]{1, 3, 2, 3, 1}));
    }
}
