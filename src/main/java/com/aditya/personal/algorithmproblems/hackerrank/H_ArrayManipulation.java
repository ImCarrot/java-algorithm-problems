package com.aditya.personal.algorithmproblems.hackerrank;

public class H_ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {

        int size = n + 2;

        long[] data = new long[size];

        for (int[] query : queries) {

            data[query[0]] += query[2];

            data[query[1] + 1] -= query[2];
        }

        long[] sums = new long[size];
        long currentMax = Integer.MIN_VALUE;

        for (int i = 1; i < size; i++) {
            sums[i] = sums[i - 1] + data[i];
            currentMax = Math.max(currentMax, sums[i]);
        }

        return currentMax;

    }

}
