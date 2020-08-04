package com.aditya.personal.algorithmproblems.leetCode;

import java.util.*;

public class M_139_WordBreak {

    Map<String, Boolean> processed = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        return breakWord(s, dict);

    }

    private boolean breakWord(String s, Set<String> dict) {

        if (processed.containsKey(s))
            return processed.get(s);

        if (s.length() == 0)
            return true;

        for (int i = 1; i <= s.length(); i++) {

            if (dict.contains(s.substring(0, i)) && breakWord(s.substring(i, s.length()), dict)) {
                processed.put(s, true);
                return true;
            }
        }

        processed.put(s, false);
        return false;
    }

    public static void main(String[] args) {

        M_139_WordBreak instance = new M_139_WordBreak();

        System.out.println(instance.wordBreak("leetcode", Arrays.asList("leet","code")));
    }
}
