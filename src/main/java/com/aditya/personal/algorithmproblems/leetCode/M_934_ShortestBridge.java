package com.aditya.personal.algorithmproblems.leetCode;

public class M_934_ShortestBridge {

    public int shortestBridge(int[][] A) {

        int[] island = findIsland(A);

        if (island == null)
            return -1;

        return findIncrement(A, island[0], island[1], 1);
    }

    private int[] findIsland(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {

                if (A[i][j] != 1)
                    continue;

                // upper bound
                if (i > 0 && A[i - 1][j] == 1)
                    continue;

                // lower bound
                if (i < A.length - 1 && A[i + 1][j] == 1)
                    continue;

                // left bound
                if (j > 0 && A[i][j - 1] == 1)
                    continue;

                // right bound
                if (j < A[i].length - 1 && A[i][j + 1] == 1)
                    continue;

                return new int[]{i, j};
            }
        }

        return null;
    }

    private int findIncrement(int[][] matrix, int cRow, int cColumn, int inc) {

        // meaning inbound bottom & found land
        if (cRow + inc < matrix.length && matrix[cRow + inc][cColumn] == 1)
            return inc;

        // meaning inbound top & found land
        if (cRow - inc >= 0 && matrix[cRow - inc][cColumn] == 1)
            return inc;

        // meaning inbound right & found land
        if (cColumn + inc < matrix[cRow].length && matrix[cRow][cColumn + inc] == 1)
            return inc;

        // meaning inbound left & found land
        if (cColumn - inc >= 0 && matrix[cRow][cColumn - inc] == 1)
            return inc;

        if (cRow + inc + 1 >= matrix.length && cRow - inc - 1 < 0 &&
                cColumn + inc + 1 >= matrix[cRow].length && cColumn - inc - 1 < 0)
            return 1000;

        // sink current
        matrix[cRow][cColumn] = 0;

        return findIncrement(matrix, cRow, cColumn, inc + 1);
    }

    public static void main(String[] args) {
        M_934_ShortestBridge instance = new M_934_ShortestBridge();

        int[][] inp1 = new int[][]{{0, 1}, {1, 0}};
        System.out.println(instance.shortestBridge(inp1));

        /*
    [[1,1,1,1,1],
     [1,0,0,0,1],
     [1,0,0,0,1],
     [1,0,1,0,1],
     [1,0,0,0,1],
     [1,0,0,0,1],
     [1,1,1,1,1]]

     [[0,1],
      [1,0]]

    */

    }

}
