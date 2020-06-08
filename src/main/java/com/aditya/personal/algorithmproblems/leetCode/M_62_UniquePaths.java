package com.aditya.personal.algorithmproblems.leetCode;

public class M_62_UniquePaths {

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++)
            dp[row][0] = 1;

        for (int column = 0; column < n; column++)
            dp[0][column] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int[] hey(){
        return new int[]{0, 1};
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3)); // should be 28
    }
}
