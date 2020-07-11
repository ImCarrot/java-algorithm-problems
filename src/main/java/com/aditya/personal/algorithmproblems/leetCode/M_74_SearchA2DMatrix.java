package com.aditya.personal.algorithmproblems.leetCode;

public class M_74_SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i].length == 0)
                continue;

            if (matrix[i][0] > target)
                break;

            if (matrix[i][matrix[i].length - 1] < target)
                continue;

            if (foundBinary(matrix[i], target, 0, matrix[i].length - 1))
                return true;

        }
        return false;
    }

    private boolean foundBinary(int[] nums, int target, int start, int end) {
        if (start > end)
            return false;

        int mid = start + (end - start) / 2;

        if (nums[mid] == target)
            return true;

        if (nums[mid] > target)
            return foundBinary(nums, target, start, mid - 1);

        return foundBinary(nums, target, mid + 1, end);
    }

}
