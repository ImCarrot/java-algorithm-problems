package com.aditya.personal.algorithmproblems.ctci.ArraysAndStrings;

public class OneAway {

    public static boolean checkIfOneChangeAway(String matchFrom, String toMatch) {

        if (matchFrom == null || toMatch == null)
            return false;

        if (matchFrom.length() - toMatch.length() > 1)
            return false;

        int[] charFlags = new int[128]; // considering ASCII

        for (char c : matchFrom.toCharArray())
            charFlags[c] += 1;

        int differenceCount = 0;

        for (char c : toMatch.toCharArray()) {

            int value = charFlags[c];

            if (value == 1) {
                charFlags[c] -= 1;
                continue;
            }

            differenceCount += 1;
        }


        return differenceCount < 2;
    }

    public static void main(String[] args) {
        System.out.println(checkIfOneChangeAway("pale", "ple"));
        System.out.println(checkIfOneChangeAway("pales", "pale"));
        System.out.println(checkIfOneChangeAway("pale", "bale"));
        System.out.println(checkIfOneChangeAway("pale", "bake"));
        System.out.println(checkIfOneChangeAway("pale", "lpae"));

    }

}
