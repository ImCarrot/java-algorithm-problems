package com.aditya.personal.algorithmproblems.ctci.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class PermutaionOfPalindrome {

    public static boolean permutationOfPalindrome(String input) {

        if (input == null || input.trim().isEmpty())
            return false;

        Map<Character, Integer> charCounts = new HashMap<>();

        for(char c : input.toCharArray()) {

            if (c == ' ')
                continue;

            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        boolean isOddAllowed = true;

        for (Map.Entry<Character, Integer> charOccur : charCounts.entrySet()) {

            int mod = charOccur.getValue() % 2;

            if (mod != 0) {

                if (isOddAllowed) {
                    isOddAllowed = false;
                    continue;
                }
                return false;
            } else {
                continue;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(permutationOfPalindrome("Tact Coa".toLowerCase()));
    }

}
