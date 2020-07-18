package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class E_344_ReverseString {

    public void reverseString(char[] s) {

        for (int i = 0, j = s.length - 1; i < s.length && j >= 0; i++) {

            if (i >= j)
                break;

            int[] p = new int[] {1, 2, 3, 4, 5, 6};

            int[] q = new int[4];
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }

}
