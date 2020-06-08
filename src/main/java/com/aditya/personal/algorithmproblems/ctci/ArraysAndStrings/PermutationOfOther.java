package com.aditya.personal.algorithmproblems.ctci.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfOther {

    public static boolean isPermutation(String first, String second) {

        if (first == null || first.trim().isEmpty())
            return false;

        if (second == null || second.trim().isEmpty())
            return false;

        Map<Character, Integer> chars = new HashMap<>();
        for (char c : second.toCharArray())
            chars.put(c, chars.getOrDefault(c, 0) + 1);

        for (char c : first.toCharArray()) {
            if (chars.getOrDefault(c, 0) < 1)
                return false;

            chars.put(c, chars.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("fdaa", "abcdef"));
    }
}
