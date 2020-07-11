package com.aditya.personal.algorithmproblems.leetCode;

public class M_33_SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        int pivot = findPivot(nums, 0, nums.length - 1);

        if (pivot == -1)
            return binarySearch(nums, target, 0, nums.length - 1);

        if (target <= nums[nums.length - 1])
            return binarySearch(nums, target, pivot, nums.length - 1);

        return binarySearch(nums, target, 0, pivot - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {

        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[mid] > target)
            return binarySearch(nums, target, start, mid - 1);

        return binarySearch(nums, target, mid + 1, end);
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

    public static void main(String[] args) {
        M_33_SearchRotatedSortedArray instance = new M_33_SearchRotatedSortedArray();
        System.out.println(instance.search(new int[]{2, 3, 4, 5, 6, 7, 0, 1}, 0));
    }

}
