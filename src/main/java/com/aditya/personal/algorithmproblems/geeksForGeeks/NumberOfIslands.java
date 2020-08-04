package com.aditya.personal.algorithmproblems.geeksForGeeks;

public class NumberOfIslands {

    public static int countIslands(int[][] mat) {

        int islandCount = 0;
        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 0)
                    continue;

                tagIsland(mat, i, j);
                islandCount++;

            }
        }
        return islandCount;
    }

    private static void tagIsland(int[][] mat, int i, int j) {

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length)
            return;

        if (mat[i][j] == 0)
            return;

        mat[i][j] = 0;
        tagIsland(mat, i + 1, j);
        tagIsland(mat, i - 1, j);
        tagIsland(mat, i, j+1);
        tagIsland(mat, i, j-1);
        tagIsland(mat, i-1, j-1);
        tagIsland(mat, i+1, j+1);
        tagIsland(mat, i-1, j+1);
        tagIsland(mat, i+1, j-1);
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        System.out.println(countIslands(mat));
    }
}
