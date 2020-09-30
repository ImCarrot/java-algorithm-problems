package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M_1055_ShortestWayToFormString {

    public int numSubstring(String input, String target) {

        Map<Character, List<Integer>> charIndexes = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {

            if (!charIndexes.containsKey(input.charAt(i)))
                charIndexes.put(input.charAt(i), new ArrayList<>());

            charIndexes.get(input.charAt(i)).add(i);
        }

        int minLength = 0;
        for (int i = 0; i < target.length(); i++) {

            if (!charIndexes.containsKey(target.charAt(i)))
                return -1;

            List<Integer> indexes = charIndexes.get(target.charAt(i));

            int max = 0;

            for (int index: indexes) {

                int maxSubstring = findMaxLength(input, target, index, i);
                max = Math.max(max, maxSubstring);
            }
            minLength++;
            i += max - 1;
        }

        return minLength;
    }

    private int findMaxLength(String input, String target, int start, int matchIndex) {

        int end = start;
        while (end < input.length() && matchIndex < target.length() && input.charAt(end) == target.charAt(matchIndex)) {
            end++;
            matchIndex++;
        }

        return end - start;
    }

    public static void main(String[] args) {
        M_1055_ShortestWayToFormString instance = new M_1055_ShortestWayToFormString();
//        System.out.println(instance.numSubstring("baz", "zaza"));
        System.out.println(instance.numSubstring("xyz", "xzyxz"));
//        System.out.println(instance.numSubstring("abc", "acdbc"));
    }

}
