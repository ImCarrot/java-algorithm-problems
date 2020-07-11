package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;

public class M_454_4SumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> sumFreq = new HashMap<>();

        for (int value : A) {
            for (int i : B) {
                int sum = value + i;
                sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int value : C) {
            for (int i : D) {
                int negSum = (value + i) * -1;
                count += sumFreq.getOrDefault(negSum, 0);
            }
        }

        return count;
    }

}
