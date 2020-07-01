package com.aditya.personal.algorithmproblems.hackerrank;

public class MinimumSwaps2 {

    static int swaps = 0;

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int[] sorted = mergeSort(arr);
        return swaps;
    }

    static int[] mergeSort(int[] numbers) {

        if (numbers.length <= 1)
            return numbers;

        int mid = numbers.length / 2;

        int[] leftArr = new int[mid];
        System.arraycopy(numbers, 0, leftArr, 0, mid);

        int[] rightArr = new int[numbers.length - mid];
        int counter = 0;
        for (int i = mid; i < numbers.length; i++) {
            rightArr[counter] = numbers[i];
            counter++;
        }

        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);

        return mergeTwoSortedArrays(leftArr, rightArr);
    }

    private static int[] mergeTwoSortedArrays(int[] left, int[] right) {

        if (left.length == 0)
            return right;

        if (right.length == 0)
            return left;

        int[] toReturn = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length || j < right.length) {

            if (i == left.length)
                toReturn[k++] = right[j++];
            else if (j == right.length)
                toReturn[k++] = left[i++];
            else {

                if (left[i] < right[j]) {
                    toReturn[k++] = left[i++];
                } else {
                    toReturn[k++] = right[j++];
                    swaps += 1;
                }
            }

        }
        return toReturn;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
    }

}
