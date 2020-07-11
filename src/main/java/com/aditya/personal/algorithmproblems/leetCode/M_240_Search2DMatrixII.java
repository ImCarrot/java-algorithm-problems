package com.aditya.personal.algorithmproblems.leetCode;

public class M_240_Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int row = 0; row < matrix.length; row++) {

            if (matrix[row].length == 0)
                continue;

            if (target < matrix[row][0])
                continue;

            if (target > matrix[row][matrix[row].length - 1])
                continue;

            if (foundBinary(matrix[row], target, 0, matrix[row].length - 1))
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
