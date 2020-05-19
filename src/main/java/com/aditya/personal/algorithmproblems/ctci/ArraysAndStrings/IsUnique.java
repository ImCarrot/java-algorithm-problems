package com.aditya.personal.algorithmproblems.ctci.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public static boolean checkUniqueWithDS(String input) {

        if (input == null || input.trim().isEmpty())
            return false;

        Set<Character> usedChars = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {

            if (usedChars.contains(input.charAt(i)))
                return false;
            usedChars.add(input.charAt(i));
        }
        return true;
    }

    /**
     * Since cannot use an data structures we use a Bit Vector kind of approach.
     * The idea is, since the string is all alphabets, then we can init an array
     * of ints of size 26 and then increment the value by 1 at the position of
     * the int value of the char.
     * <p>
     * This would throw an error if the character's aren't all alphabets
     *
     * @param input the input string.
     * @return true if all characters are unique
     */
    public static boolean checkUniqueWoDS(String input) {

        if (input == null || input.trim().isEmpty())
            return false;

        int[] charInts = new int[26];

        for (int i = 0; i < input.length(); i++) {

            //noinspection DuplicateExpressions
            if (charInts[input.charAt(i) - 'a'] == 1)
                return false;

            //noinspection DuplicateExpressions
            charInts[input.charAt(i) - 'a'] += 1;
        }
        return true;
    }

    /**
     * refer: https://stackoverflow.com/questions/9141830/explain-the-use-of-a-bit-vector-for-determining-if-all-characters-are-unique
     *
     * @param input the input string.
     * @return true if all characters are unique
     */
    public static boolean checkUniqueWoDSActualBitVector(String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); ++i) {
            int val = input.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }


    /**
     * Problem Statement: Implement an algorithm to determine if a string has all unique characters. Once done,
     * try out what if you cannot use any additional data structures.
     *
     * @param args none
     */
    public static void main(String[] args) {
        System.out.println(checkUniqueWithDS("abab"));
        System.out.println(checkUniqueWithDS("abcd"));
        System.out.println(checkUniqueWithDS("azya"));
        System.out.println("Without DS");
        System.out.println(checkUniqueWoDS("abab"));
        System.out.println(checkUniqueWoDS("abcd"));
        System.out.println(checkUniqueWoDS("azya"));

        System.out.println("Actual Bit Ops");
        System.out.println(checkUniqueWoDSActualBitVector("az/ya92"));
    }

}
