package com.aditya.personal.algorithmproblems.ctci.ArraysAndStrings;

import java.util.Stack;

public class ZeroMatrix {


    public static int[][] zeroMatrix(int[][] matrix) {


        int rows = matrix.length;
        int columns = matrix[0].length;

        Stack<Integer> columnsToZero = new Stack<>();
        Stack<Integer> rowsToZero = new Stack<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero.push(i);
                    columnsToZero.push(j);
                }
            }
        }

        while(!columnsToZero.empty()) {
            int column = columnsToZero.pop();
            for (int i = 0; i < rows; i++) {
                matrix[i][column] = 0;
            }
        }

        while(!rowsToZero.empty()) {
            int row = rowsToZero.pop();
            matrix[row] = new int[columns];
        }


        return matrix;
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

        int[][] p = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};

        printMatrix(p);
        System.out.println("-----------");
        int[][] r = zeroMatrix(p);

        printMatrix(r);

        System.out.println("Done!");

    }

}
