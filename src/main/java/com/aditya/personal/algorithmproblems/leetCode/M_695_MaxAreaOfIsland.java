package com.aditya.personal.algorithmproblems.leetCode;

public class M_695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int currentMax = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 0)
                    continue;

                int area = calculateArea(grid, i, j);

                currentMax = Math.max(currentMax, area);
            }
        }
        return currentMax;
    }

    private int calculateArea(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0; // submerge the current spot

        int top = calculateArea(grid, i-1, j);
        int bottom = calculateArea(grid, i+1, j);
        int left = calculateArea(grid, i, j-1);
        int right = calculateArea(grid, i, j+1);

        return top + bottom + right + left + 1;

    }

}
