package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;

public class M_659_SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {

        if (nums.length < 3)
            return false;

        Map<Integer, Integer> occurances = new HashMap<>();

        for (Integer number: nums)
            occurances.put(number, occurances.getOrDefault(number, 0) + 1);

        Map<Integer, Integer> vacancyMap = new HashMap<>();

        for (int num : nums) {

            if (occurances.get(num) == 0)
                continue;

            if (vacancyMap.getOrDefault(num, 0) > 0) {
                vacancyMap.put(num, vacancyMap.get(num) - 1);
                vacancyMap.put(num + 1, vacancyMap.getOrDefault(num + 1, 0) + 1);
                occurances.put(num, occurances.get(num) - 1);
                continue;
            }

            if (occurances.getOrDefault(num + 1, 0) > 0 && occurances.getOrDefault(num + 2, 0) > 0) {
                occurances.put(num, occurances.get(num) - 1);
                occurances.put(num + 1, occurances.get(num + 1) - 1);
                occurances.put(num + 2, occurances.get(num + 2) - 1);

                vacancyMap.put(num + 3, vacancyMap.getOrDefault(num + 3, 0) + 1);
                continue;
            }

            return false;
        }

//        for (Map.Entry<Integer, Integer> entry : occurances.entrySet()) {
//            if (entry.getValue() > 0)
//                return false;
//        }

        return true;
    }

    public static void main(String[] args) {
        M_659_SplitArrayIntoConsecutiveSubsequences instance = new M_659_SplitArrayIntoConsecutiveSubsequences();
        System.out.println(instance.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
    }

}
