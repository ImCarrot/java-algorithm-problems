package com.aditya.personal.algorithmproblems.leetCode;

public class M_48_RotateImage {

    public static void rotateWithWhile(int[][] matrix) {

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix[i].length - i - 1; j++) {

                int sourceRow = i;
                int sourceColumn = j;
                int value = matrix[sourceRow][sourceColumn];

                boolean isFirstLoop = true;

                while((sourceRow != i || sourceColumn != j) || isFirstLoop) {

                    if (isFirstLoop)
                        isFirstLoop = false;

                    int destinationRow = sourceColumn;
                    int destinationColumn = matrix.length - 1 - sourceRow;

                    int temp = matrix[destinationRow][destinationColumn];
                    matrix[destinationRow][destinationColumn] = value;

                    sourceRow = destinationRow;
                    sourceColumn = destinationColumn;
                    value = temp;
                }
            }
        }
    }

    public static void rotate(int[][] matrix) {

        int N = matrix.length;

        for (int i = 0; i < N / 2; i++) {

            for (int j = i; j < N - i - 1; j++) {

                int temp = matrix[i][j];

                matrix[i][j] = matrix[N - 1 - j][i];

                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];

                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];

                matrix[j][N - 1 - i] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + "     ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // 103, 215, 671
        int[][] p = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printMatrix(p);
        System.out.println("-----------");
        rotate(p);
// int[][] r =
//        printMatrix(r);

        System.out.println("Done!");
    }

}
