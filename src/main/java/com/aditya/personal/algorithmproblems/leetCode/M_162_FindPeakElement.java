package com.aditya.personal.algorithmproblems.leetCode;

public class M_162_FindPeakElement {

    public int findPeakElement(int[] nums) {

        if (nums.length == 0)
            return -1;

        return performBinary(nums, 0, nums.length - 1);

    }

    private int performBinary(int[] nums, int start, int end) {

        if (start > end)
            return -1;

        if (start == end)
            return start;

        int mid = start + (end - start) / 2;

        if (mid == 0) {
            if (nums[mid] > nums[mid + 1])
                return mid;
            else
                return performBinary(nums, mid + 1, end);
        } else if (mid == nums.length - 1) {
            if (nums[mid] > nums[mid - 1])
                return mid;
            else
                return performBinary(nums, start, mid - 1);
        }

        if (nums[mid] < nums[mid + 1])
            return performBinary(nums, mid + 1, end);

        if (nums[mid] < nums[mid - 1])
            return performBinary(nums, start, mid - 1);

        return mid;
    }

}
