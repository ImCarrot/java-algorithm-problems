package com.aditya.personal.algorithmproblems.leetCode;

public class M_64_MinimumPathSum {

    public static int minPathSum(int[][] grid) {

        int[][] costs = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                // entry
                if (i == 0 && j == 0) {
                    costs[i][j] = grid[i][j];
                    continue;
                }

                if (j == 0) {
                    costs[i][j] = costs[i - 1][j] + grid[i][j];
                    continue;
                }

                if (i == 0) {
                    costs[i][j] = costs[i][j - 1] + grid[i][j];
                    continue;
                }

                costs[i][j] = Math.min(costs[i][j-1], costs[i-1][j]) + grid[i][j];
            }
        }
        return costs[grid.length -1][grid[0].length - 1];

    }

    public static void main(String[] args) {

        int[][] input = new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}};

        System.out.println(minPathSum(input));
    }

}
