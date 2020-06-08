package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class M_692_TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> counts = new HashMap<>();

        for (String word : words)
            counts.put(word, counts.getOrDefault(word, 0) + 1);

        return counts.keySet().stream()
                .sorted((w1, w2)-> {
                    int comparisonResult = counts.get(w2).compareTo(counts.get(w1));

                    if (comparisonResult != 0)
                        return comparisonResult;

                    return w1.compareTo(w2);
                }).limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        M_692_TopKFrequentWords instance = new M_692_TopKFrequentWords();

        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> output = instance.topKFrequent(input, k);
        System.out.println(output); // expected: ["i", "love"]

        String[] second_input = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        k = 4;
        output = instance.topKFrequent(second_input, k);
        System.out.println(output); // expected: ["the", "is", "sunny", "day"]
    }

}
