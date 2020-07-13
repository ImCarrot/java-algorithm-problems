package com.aditya.personal.algorithmproblems.leetCode;

public class E_977_SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {

        int[] output = new int[A.length];

        int left = 0;
        int right = A.length - 1;
        int outPointer = A.length -1;

        while (outPointer >=0) {

            int leftSq = A[left] * A[left];
            int rightSq = A[right] * A[right];

            if (rightSq >= leftSq) {
                output[outPointer--] = rightSq;
                right--;
            } else {
                output[outPointer--] = leftSq;
                left++;
            }
        }
        return output;
    }
}
