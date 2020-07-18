package com.aditya.personal.algorithmproblems.hackerrank.dictionaryAndHashMaps;

import java.util.*;

public class M_FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        Map<Integer, Integer> digitCounts = new HashMap<>();
        Map<Integer, Integer> occCounts = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        for (List<Integer> query : queries) {

            if (query.get(0) == 3) {

//                boolean found = digitCounts.values().stream().anyMatch(x-> x.equals(query.get(1)));
                boolean found = occCounts.getOrDefault(query.get(1), 0) > 0;
                if (found)
                    output.add(1);
                else
                    output.add(0);
                continue;
            }

            int op = query.get(0);
            int val = query.get(1);

            int oldFreq = digitCounts.getOrDefault(val, 0);
            int diff = op == 1 ? 1 : -1;

            if (op == 1) {
                digitCounts.put(val, digitCounts.getOrDefault(val, 0) + 1);
                if (oldFreq != 0)
                    occCounts.put(oldFreq, occCounts.get(oldFreq) - 1);
                occCounts.put(oldFreq + diff, occCounts.getOrDefault(oldFreq + diff, 0) + 1);
            } else if (op == 2) {

                if (!digitCounts.containsKey(val))
                    continue;

                if (digitCounts.get(val) == 1) {
                    digitCounts.remove(val);
                } else
                    digitCounts.put(val, digitCounts.get(val) - 1);

                occCounts.put(oldFreq, occCounts.get(oldFreq) - 1);
                occCounts.put(oldFreq + diff, occCounts.getOrDefault(oldFreq + diff, 0) + 1);

            }
        }
        return output;
    }

    public static void main(String[] args) {
        freqQuery(Arrays.asList(Arrays.asList(3, 4), Arrays.asList(2, 1003), Arrays.asList(1, 16), Arrays.asList(3, 1)));
    }

}
