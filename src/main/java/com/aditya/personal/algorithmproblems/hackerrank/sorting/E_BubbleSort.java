package com.aditya.personal.algorithmproblems.hackerrank.sorting;

public class E_BubbleSort {

    static void countSwaps(int[] a) {

        int totalSwaps = 0;
        int lastOpSwaps = -1;

        while (lastOpSwaps != 0) {
            lastOpSwaps = 0;
            for (int i = 0; i < a.length - 1; i++) {

                if (a[i] > a[i + 1]) {
                    int temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                    totalSwaps++;
                    lastOpSwaps++;
                }
            }
        }

        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

}
