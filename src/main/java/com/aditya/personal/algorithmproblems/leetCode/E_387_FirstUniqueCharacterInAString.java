package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;

public class E_387_FirstUniqueCharacterInAString {

    public int firstUniqueChar(String s) {

        if (s == null || s.isEmpty())
            return -1;

        Map<Character, Integer> charCounts = new HashMap<>();

        char[] chars = s.toCharArray();

        for (char aChar : chars)
            charCounts.put(aChar, charCounts.getOrDefault(aChar, 0) + 1);

        // to extract the index
        int minIndex = chars.length;
        for (int i = 0; i < chars.length; i++) {

            if (charCounts.get(chars[i]) == 1 && i < minIndex)
                minIndex = i;

        }

        return minIndex == chars.length ? -1 : minIndex;
    }

    public static void main(String[] args) {
        E_387_FirstUniqueCharacterInAString instance = new E_387_FirstUniqueCharacterInAString();

        String input = "leetcode";
        int output = instance.firstUniqueChar(input);
        System.out.println(output); // expected: 0

        input = "loveleetcode";
        output = instance.firstUniqueChar(input);
        System.out.println(output); // expected: 2
    }
}
