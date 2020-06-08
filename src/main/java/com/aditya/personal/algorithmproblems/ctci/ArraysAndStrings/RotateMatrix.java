package com.aditya.personal.algorithmproblems.ctci.ArraysAndStrings;

public class RotateMatrix {

    public static int[][] rotateMatrixClockwise(int[][] matrix) {

        int rowsOrg = matrix.length;
        int columnsOrg = matrix[0].length;

        int[][] rotatedClockwise = new int[columnsOrg][rowsOrg];

        for (int i = 0; i < rowsOrg; i++) {

            for (int j = 0; j < columnsOrg; j++) {
                rotatedClockwise[j][rowsOrg - 1 - i] = matrix[i][j];
            }
        }
        return rotatedClockwise;
    }

    public static int[][] rotateAntiClockwise(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return null;

        int rowsOrg = matrix.length;
        int columnsOrg = matrix[0].length;

        int[][] rotated = new int[columnsOrg][rowsOrg];

        for (int i = 0; i < rowsOrg; i++) {

            for (int j = 0; j < columnsOrg; j++) {

                rotated[columnsOrg - 1 - j][i] = matrix[i][j];

            }

        }
        return rotated;
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
                {13, 14, 15, 16},
                {17, 18, 19, 20}};

        printMatrix(p);
        System.out.println("-----------");
        int[][] r = rotateAntiClockwise(p);

        printMatrix(r);

        System.out.println("Done!");
    }

}
