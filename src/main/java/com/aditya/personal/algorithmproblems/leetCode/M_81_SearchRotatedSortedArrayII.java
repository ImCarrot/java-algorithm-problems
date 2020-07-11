package com.aditya.personal.algorithmproblems.leetCode;

public class M_81_SearchRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {

        int pivot = findMaxElement(nums, 0, nums.length - 1);

        if (pivot == -1)
            return findMatch(nums, target, 0, nums.length - 1);

        return findMatch(nums, target, 0, pivot) || findMatch(nums, target, pivot + 1, nums.length - 1);

    }

    private int findMaxElement(int[] nums, int start, int end) {

        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (mid + 1 >= nums.length)
            return -1;

        if (nums[mid] > nums[mid + 1])
            return mid;

        return Math.max(findMaxElement(nums, start, mid - 1), findMaxElement(nums, mid + 1, end));
    }

    private boolean findMatch(int[] nums, int target, int start, int end) {

        if (start > end)
            return false;

        int mid = start + (end - start) / 2;

        if (nums[mid] == target)
            return true;

        if (nums[mid] > target)
            return findMatch(nums, target, start, mid - 1);

        return findMatch(nums, target, mid + 1, end);
    }

}
