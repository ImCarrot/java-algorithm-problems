package com.aditya.personal.algorithmproblems.leetCode;

import java.util.*;

public class M_5454_LeastNumberofUniqueIntegersAfterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> numberCount = new HashMap<>();

        for (int number : arr)
            numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);

        List<Integer> uniqueNumbers = new ArrayList<>(numberCount.keySet());

        uniqueNumbers.sort(Comparator.comparingInt(numberCount::get));

        int n = numberCount.size();
        int remove = 0;
        int idx = 0;

        while (k >= 0 && idx < n) {
            k -= numberCount.get(uniqueNumbers.get(idx++));
            if (k >= 0) remove++;
        }

        return n - remove;
    }

    public static void main(String[] args) {
        M_5454_LeastNumberofUniqueIntegersAfterKRemovals instance = new M_5454_LeastNumberofUniqueIntegersAfterKRemovals();

        System.out.println(instance.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }
}
