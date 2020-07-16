package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M_1296_DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide_OnLogn(int[] nums, int k) {

        if (nums.length < k)
            return false;

        Arrays.sort(nums);

        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int number: nums)
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);

        for (int num : nums) {

            if (frequencies.get(num) == 0)
                continue;

            int current = num;
            int toMatch = k;
            while (toMatch != 0 && frequencies.getOrDefault(current, 0) > 0) {
                frequencies.put(current, frequencies.get(current) - 1);
                current = current + 1;
                toMatch--;
            }

            if (toMatch != 0)
                return false;
        }

        return true;
    }

    public boolean isPossibleDivide_On(int[] nums, int k) {

        if (nums.length < k)
            return false;

        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int number: nums)
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);

        for (int number: nums) {

            if (frequencies.get(number) == 0)
                continue;

            int streakStart = number;
            while (frequencies.getOrDefault(streakStart, 0) > 0)
                streakStart--;

            streakStart += 1; // since the last element that was there got decremented

            int current = streakStart;
            int toMatch = k;
            while (toMatch != 0 && frequencies.getOrDefault(current, 0) > 0) {
                frequencies.put(current, frequencies.get(current) - 1);
                current = current + 1;
                toMatch--;
            }

            if (toMatch != 0)
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        M_1296_DivideArrayInSetsOfKConsecutiveNumbers instance = new M_1296_DivideArrayInSetsOfKConsecutiveNumbers();
        System.out.println(instance.isPossibleDivide_OnLogn(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
    }

}
