package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.List;

public class M_1493_LongestSubarrayOf1AfterDeletingOneElement {

    public static int longestSubarray(int[] nums) {

        List<Integer> processedData = new ArrayList<>();

        int currentMax = 0;

        for (int num : nums) {

            if (num == 0) {
                processedData.add(currentMax);
                currentMax = 0;
                continue;
            }

            currentMax += num;
        }

        if (currentMax != 0)
            processedData.add(currentMax);

        int longest = 0;

        if (processedData.size() == 1) {

            if (processedData.get(0) == nums.length)
                return processedData.get(0) - 1;

            return processedData.get(0);
        }

        for (int i = 0; i < processedData.size() - 1; i++)
            longest = Math.max(longest, processedData.get(i) + processedData.get(i + 1));

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,0,0}));
    }

}
