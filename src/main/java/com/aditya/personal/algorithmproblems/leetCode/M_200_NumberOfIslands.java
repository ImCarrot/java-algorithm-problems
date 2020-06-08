package com.aditya.personal.algorithmproblems.leetCode;

public class M_200_NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {

                    boolean isLandOnLeft = j - 1 >= 0 && grid[i][j - 1] == '1';
                    boolean isLandOnTop = i - 1 >= 0 && grid[i - 1][j] == '1';

                    if (!isLandOnLeft && !isLandOnTop)
                        islandCount++;

                }
            }
        }
        return islandCount;
    }

    public static int numIslandsDFS(char[][] grid) {

        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {

                    islandCount += sinkAdjacent(grid, i, j);

                }
            }
        }
        return islandCount;
    }

    private static int sinkAdjacent(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        sinkAdjacent(grid, i - 1, j);
        sinkAdjacent(grid, i + 1, j);
        sinkAdjacent(grid, i, j - 1);
        sinkAdjacent(grid, i, j + 1);
        return 1;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
        int count = numIslandsDFS(grid);
        System.out.println();
    }
}
