package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class M_34_FirstAndLastIndexOfK {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0)
            return new int[]{-1, -1};

        int anyIndex = fetchAnyIndex(nums, target, 0, nums.length);

        if (anyIndex == -1)
            return new int[]{-1, -1};

        int rightMost = anyIndex;

        while (rightMost < nums.length) {

            int nextStep = rightMost + 1;

            if (nextStep >= nums.length || nums[nextStep] != target)
                break;

            rightMost++;
        }

        int leftMost = anyIndex;

        while (leftMost > 0 && nums[leftMost] == target) {

            int nextStep = leftMost - 1;

            if (nextStep < 0 || nums[nextStep] != target)
                break;
            leftMost--;
        }

        return new int[]{leftMost, rightMost};
    }

    private static int fetchAnyIndex(int[] arr, int target, int lp, int rp) {

        if (rp == lp) {

            if (lp >= 0 && lp < arr.length)
                return arr[lp] == target ? lp : -1;
            return -1;
        }

        if (rp < lp)
            return -1;

        int mid = (rp + lp) / 2;

        if (arr[mid] == target)
            return mid;

        if (arr[mid] > target)
            return fetchAnyIndex(arr, target, lp, mid - 1);

        if (arr[mid] < target)
            return fetchAnyIndex(arr, target, mid + 1, rp);

        return -1;
    }

    public static void main(String[] args) {

        M_34_FirstAndLastIndexOfK instance = new M_34_FirstAndLastIndexOfK();

        System.out.println(Arrays.toString(instance.searchRange(new int[]{1, 3}, 1)));
    }

}
