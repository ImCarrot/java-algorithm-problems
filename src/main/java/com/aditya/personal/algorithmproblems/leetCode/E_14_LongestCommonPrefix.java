package com.aditya.personal.algorithmproblems.leetCode;

public class E_14_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length < 1)
            return "";

        if (strs.length == 1)
            return strs[0];

        int maxPrefixLength = 10000;

        for (String str: strs)
            maxPrefixLength = Math.min(maxPrefixLength, str.length());

        StringBuilder toReturn = new StringBuilder();

        String starter = strs[0];

        for (int i = 0; i < maxPrefixLength; i++) {
            boolean isBreakingOut = false;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != starter.charAt(i)) {
                    isBreakingOut = true;
                    break;
                }
            }

            if (isBreakingOut)
                break;

            toReturn.append(starter.charAt(i));
        }

        return toReturn.toString();
    }

    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        String output = longestCommonPrefix(input);
        System.out.println(output);
    }
}
