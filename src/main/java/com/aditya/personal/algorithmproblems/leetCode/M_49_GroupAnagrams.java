package com.aditya.personal.algorithmproblems.leetCode;

import java.util.*;

public class M_49_GroupAnagrams {

    public Collection<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {

            String sorted = sortString(str);

            if (!groups.containsKey(sorted))
                groups.put(sorted, new ArrayList<>());

            groups.get(sorted).add(str);
        }

        return groups.values();
    }

    public String sortString(String inputString) {
        char[] tempArray = inputString.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }

    public static void main(String[] args) {
        M_49_GroupAnagrams instance = new M_49_GroupAnagrams();
        System.out.println(instance.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        /* expected:
        [
            ["ate","eat","tea"],
            ["nat","tan"],
            ["bat"]
        ]
         */
    }
}
