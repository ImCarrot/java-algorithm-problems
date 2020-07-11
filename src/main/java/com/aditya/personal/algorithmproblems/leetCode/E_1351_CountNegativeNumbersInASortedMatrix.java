package com.aditya.personal.algorithmproblems.leetCode;

public class E_1351_CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {

        int negatives = 0;

        for (int[] ints : grid) {

            if (ints[ints.length - 1] >= 0)
                continue;

            if (ints[0] < 0) {
                negatives += ints.length;
                continue;
            }

            int firstNegIndex = this.fetchFirstNegative(ints, 0, ints.length - 1);

            if (firstNegIndex == Integer.MAX_VALUE)
                continue;

            negatives += ints.length - firstNegIndex;
        }
        return negatives;
    }

    public int fetchFirstNegative(int[] row, int start, int end) {

        if (start < 0 || end >= row.length || start > end)
            return Integer.MAX_VALUE;

        int mid = start + (end - start) / 2;

        if (row[mid] >= 0)
            return fetchFirstNegative(row, mid + 1, end);

        return Math.min(mid, fetchFirstNegative(row, start, mid - 1));
    }
}
