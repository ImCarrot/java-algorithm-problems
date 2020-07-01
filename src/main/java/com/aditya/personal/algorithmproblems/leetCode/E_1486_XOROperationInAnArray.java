package com.aditya.personal.algorithmproblems.leetCode;

public class E_1486_XOROperationInAnArray {

    public int xorOperation(int n, int start) {

        int[] arr = new int[n];
        arr[0] = start;

        int result = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i] = start + 2*i;
            result = result ^ arr[i];
        }
        return result;
    }

}
