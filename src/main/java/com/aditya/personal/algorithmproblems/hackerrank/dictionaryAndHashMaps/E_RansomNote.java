package com.aditya.personal.algorithmproblems.hackerrank.dictionaryAndHashMaps;

import java.util.HashMap;
import java.util.Map;

public class E_RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> availableWords = new HashMap<>();
        for (String word: magazine) {
            String lowerWord = word.toLowerCase();
            availableWords.put(lowerWord, availableWords.getOrDefault(lowerWord, 0) + 1);
        }

        for (String word: note) {
            String lowerWord = word.toLowerCase();
            if (availableWords.getOrDefault(lowerWord, 0) <= 0){
                System.out.println("No");
                return;
            }

            availableWords.put(lowerWord, availableWords.get(lowerWord) - 1);
        }
        System.out.println("Yes");
    }
}
