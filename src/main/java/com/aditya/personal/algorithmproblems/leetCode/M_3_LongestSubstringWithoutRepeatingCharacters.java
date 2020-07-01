package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashSet;
import java.util.Set;

public class M_3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() < 2)
            return s.length();

        int globalMax = 0;

        for (int i = 0; i < s.length(); i++) {

            Set<Character> seenChars = new HashSet<>();

            int currentMax = globalMax;

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (!seenChars.contains(c))
                    seenChars.add(c);

                else {

                    int foundSize = seenChars.size();

                    if (foundSize > currentMax)
                        currentMax = foundSize;

                    seenChars.clear();
                }
            }

            if (!seenChars.isEmpty() && seenChars.size() > currentMax)
                currentMax = seenChars.size();

            if (currentMax > globalMax)
                globalMax = currentMax;

        }

        return globalMax;
    }

    public static void main(String[] args) {
        M_3_LongestSubstringWithoutRepeatingCharacters instance = new M_3_LongestSubstringWithoutRepeatingCharacters();

        System.out.println(instance.lengthOfLongestSubstring("asdfghjklaqwertyuiop"));
    }

}
