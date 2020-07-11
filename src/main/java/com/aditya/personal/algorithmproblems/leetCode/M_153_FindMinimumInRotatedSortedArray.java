package com.aditya.personal.algorithmproblems.leetCode;

public class M_153_FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int pivot = findPivot(nums, 0, nums.length - 1);

        if (pivot == -1)
            return nums[0];

        return nums[pivot];

    }

    private int findPivot(int[] nums, int start, int end) {

        if (start > end)
            return -1;

        if (start == end)
            return start;

        int mid = start + (end - start) / 2;

        if (nums[mid] > nums[end])
            return findPivot(nums, mid + 1, end);

        return findPivot(nums, start, mid);
    }

}
