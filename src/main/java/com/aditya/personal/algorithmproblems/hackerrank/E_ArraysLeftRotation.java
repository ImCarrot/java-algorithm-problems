package com.aditya.personal.algorithmproblems.hackerrank;

import java.util.Arrays;

public class E_ArraysLeftRotation {

    static int[] rotLeft(int[] a, int d) {

        int totalRotations = d % a.length;

        if (totalRotations == 0)
            return a;

        int diff = a.length - totalRotations;

        int[] toReturn = new int[a.length];

        int currentPointer;
        for (currentPointer = 0; currentPointer < a.length - diff; currentPointer++)
            toReturn[currentPointer + diff] = a[currentPointer];

        for (int i = 0; i < diff; i++) {
            toReturn[i] = a[currentPointer];
            currentPointer++;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 2)));
    }
}
