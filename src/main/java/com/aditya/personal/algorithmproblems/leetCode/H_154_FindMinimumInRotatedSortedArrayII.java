package com.aditya.personal.algorithmproblems.leetCode;

public class H_154_FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int pivot = findMaxElement(nums, 0, nums.length - 1);

        if (pivot == -1)
            return nums[0];

        return nums[pivot + 1];
    }

    private int findMaxElement(int[] nums, int start, int end) {

        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (mid + 1 >= nums.length)
            return -1;

        if (nums[mid] > nums[mid + 1])
            return mid;

        int left = findMaxElement(nums, start, mid - 1);

        if (left != -1)
            return left;

        return findMaxElement(nums, mid + 1, end);
    }

}
