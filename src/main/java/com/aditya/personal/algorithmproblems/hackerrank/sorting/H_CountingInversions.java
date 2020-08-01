package com.aditya.personal.algorithmproblems.hackerrank.sorting;

import java.util.Arrays;

public class H_CountingInversions {

    static long countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static long mergeAndCount(int[] arr, int lp, int mid, int rp) {

        int[] left = Arrays.copyOfRange(arr, lp, mid + 1);

        int[] right = Arrays.copyOfRange(arr, mid + 1, rp + 1);

        int i = 0, j = 0, k = lp;
        long swaps = 0;

        while (i < left.length || j < right.length) {

            if (i == left.length)
                arr[k++] = right[j++];

            else if (j == right.length)
                arr[k++] = left[i++];

            else if (left[i] <= right[j])
                arr[k++] = left[i++];

            else {
                arr[k++] = right[j++];
                swaps += (mid + 1) - (lp + i);
            }
        }

        return swaps;
    }

    private static long mergeSortAndCount(int[] arr, int lp, int rp) {

        long count = 0;

        if (lp < rp) {

            int m = (lp + rp) / 2;

            count += mergeSortAndCount(arr, lp, m);

            count += mergeSortAndCount(arr, m + 1, rp);

            count += mergeAndCount(arr, lp, m, rp);
        }

        return count;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};

        System.out.println(countInversions(arr));
    }

}
