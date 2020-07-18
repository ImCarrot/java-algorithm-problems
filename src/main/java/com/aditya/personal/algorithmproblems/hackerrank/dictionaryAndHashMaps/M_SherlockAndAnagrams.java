package com.aditya.personal.algorithmproblems.hackerrank.dictionaryAndHashMaps;

import java.util.*;

public class M_SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {

        char[] characters = s.toCharArray();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            Map<String, Integer> anagrams = new HashMap<>();

            for (int j = 0; j < s.length() - i + 1; j++) {
                char[] chars = Arrays.copyOfRange(characters, j, j+i);

                if (chars.length == 0)
                    continue;

                Arrays.sort(chars);
                String sorted = new String(chars);

                anagrams.put(sorted, anagrams.getOrDefault(sorted, 0) + 1);

                count += anagrams.get(sorted) - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("mom"));
        System.out.println(sherlockAndAnagrams("abba"));
    }

}
