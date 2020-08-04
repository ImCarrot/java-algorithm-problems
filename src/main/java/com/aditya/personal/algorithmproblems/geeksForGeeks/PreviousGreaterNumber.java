package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterNumber {

    public static int[] previousGreaterElement(int[] arr) {

        if (arr.length == 0)
            return null;

        Stack<Integer> lastHigh = new Stack<>();

        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!lastHigh.isEmpty() && lastHigh.peek() <= arr[i])
                lastHigh.pop();

            output[i] = lastHigh.isEmpty() ? -1 : lastHigh.peek();
            lastHigh.push(arr[i]);
        }
        return output;
    }

    public static int[] nextGreaterElement(int[] arr) {

        if (arr.length == 0)
            return null;

        Stack<Integer> lastHigh = new Stack<>();

        int[] output = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!lastHigh.isEmpty() && lastHigh.peek() <= arr[i])
                lastHigh.pop();

            output[i] = lastHigh.isEmpty() ? -1 : lastHigh.peek();
            lastHigh.push(arr[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(previousGreaterElement(new int[]{10, 4, 2, 20, 40, 12, 30})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{13, 7, 6, 12})));
    }
}
