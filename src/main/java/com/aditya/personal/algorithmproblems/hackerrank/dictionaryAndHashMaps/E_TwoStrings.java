package com.aditya.personal.algorithmproblems.hackerrank.dictionaryAndHashMaps;

import java.util.HashSet;
import java.util.Set;

public class E_TwoStrings {

    static String twoStrings(String s1, String s2) {

        Set<Character> chars1 = new HashSet<>();
        for (char c: s1.toLowerCase().toCharArray())
            chars1.add(c);

        for (char c: s2.toLowerCase().toCharArray()) {
            if (chars1.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }

}
