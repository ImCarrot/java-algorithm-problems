package com.aditya.personal.algorithmproblems.Algorithms;

import java.util.Arrays;

public class QuickSort {

    public int[] quickSort(int[] numbers, int start, int end) {

        if (start >= end)
            return numbers;

        int pIndex = partition(numbers, start, end);

        numbers = quickSort(numbers, start, pIndex - 1);
        numbers = quickSort(numbers, pIndex + 1, end);

        return numbers;
    }

    public int partition(int[] numbers, int start, int end) {

        int pivot = numbers[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (numbers[i] < pivot) {
                int temp = numbers[pIndex];
                numbers[pIndex] = numbers[i];
                numbers[i] = temp;
                pIndex++;
            }
        }

        numbers[end] = numbers[pIndex];
        numbers[pIndex] = pivot;

        return pIndex;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] input = {1, 5, 9, 2, 9, 0, 3, 1};
        int[] output = sort.quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(output)); // expected: 0, 1, 1, 2, 3, 5, 9, 9
    }
}
