package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class M_300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int longest = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        M_300_LongestIncreasingSubsequence instance = new M_300_LongestIncreasingSubsequence();
        System.out.println(instance.lengthOfLIS(new int[]{-2, 1}));
    }

}
