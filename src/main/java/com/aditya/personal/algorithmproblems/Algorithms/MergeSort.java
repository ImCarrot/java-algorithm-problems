package com.aditya.personal.algorithmproblems.Algorithms;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int... numbers) {

        if (numbers.length < 2)
            return numbers;

        int midpoint = numbers.length / 2;

        int[] left = new int[midpoint];
        System.arraycopy(numbers, 0, left, 0, midpoint);

        int[] right = new int[numbers.length - midpoint];
        int counter = 0;
        for (int i = midpoint; i < numbers.length; i++) {
            right[counter] = numbers[i];
            counter++;
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return mergeTwoSortedArrays(left, right);
    }

    private int[] mergeTwoSortedArrays(int[] left, int[] right) {

        if (left == null || left.length == 0)
            return right;

        if (right == null || right.length == 0)
            return left;

        int[] toReturn = new int[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int returnPointer = 0;

        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] <= right[rightPointer]) {
                toReturn[returnPointer] = left[leftPointer];
                leftPointer++;
            } else {
                toReturn[returnPointer] = right[rightPointer];
                rightPointer++;
            }
            returnPointer++;
        }

        while (leftPointer < left.length) {
            toReturn[returnPointer] = left[leftPointer];
            leftPointer++;
            returnPointer++;
        }

        while (rightPointer < right.length) {
            toReturn[returnPointer] = right[rightPointer];
            rightPointer++;
            returnPointer++;
        }

        return toReturn;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] output = sort.mergeSort(1, 5, 9, 2, 9, 0, 3, 1);
        System.out.println(Arrays.toString(output)); // expected: 0, 1, 1, 2, 3, 5, 9, 9
    }

}
