package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashSet;
import java.util.Set;

public class H_128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> numbers = new HashSet<>();

        for (int number: nums)
            numbers.add(number);

        int longest = 0;

        for (int num : nums) {

            int number = num;
            int inSeq = 1;

            while (numbers.contains(number + 1)) {
                inSeq++;
                number++;
            }

            longest = Math.max(longest, inSeq);
        }

        return longest;
    }

}
