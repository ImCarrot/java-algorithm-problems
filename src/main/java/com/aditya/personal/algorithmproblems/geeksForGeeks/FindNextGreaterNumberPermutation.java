package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.*;

public class FindNextGreaterNumberPermutation {

    public static String nextGreaterPermutation(String number) {

        char[] digits = number.toCharArray();

        char smallest = '9';
        int smallestIndex = -1;

        int pivotIndex = -1;
        for (int i = number.length() - 2; i >=0 ; i--) {

            int current = number.charAt(i) - '0';
            int prev = number.charAt(i + 1) - '0';

            if (current < prev) {
                digits[smallestIndex] = digits[i];
                digits[i] = smallest;
                pivotIndex = i;
                break;
            }

            if (current < smallest) {
                smallest = number.charAt(i);
                smallestIndex = i;
            }
        }

        if (pivotIndex == -1)
            return null;

        List<Character> onTheRight = new ArrayList<>();

        for (int i = pivotIndex + 1; i < number.length(); i++)
            onTheRight.add(number.charAt(i));

        Collections.sort(onTheRight);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i <= pivotIndex; i++)
            output.append(number.charAt(i));

        for (Character digit: onTheRight)
            output.append(digit);

        return output.toString();

    }

    public static void main(String[] args) {
        System.out.println(nextGreaterPermutation("1"));
    }
}
