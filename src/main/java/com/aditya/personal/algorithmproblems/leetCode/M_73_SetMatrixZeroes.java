package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;
import java.util.Stack;

public class M_73_SetMatrixZeroes {

    public int[][] setZeroes(int[][] matrix) {

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

    public static void main(String[] args) {
        M_73_SetMatrixZeroes instances = new M_73_SetMatrixZeroes();

        int[][] input = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] output = instances.setZeroes(input);
        System.out.println(Arrays.deepToString(output)); // expected: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]

    }
}
