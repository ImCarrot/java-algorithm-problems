package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class M_130_SurroundedRegions {

    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] != 'O')
                    continue;

                tryToFlip(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == '_')
                    board[i][j] = 'O';
            }
        }
    }

    private boolean tryToFlip(char[][] board, int i, int j) {

        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 'X')
            return true;

        if (i == board.length - 1 || i == 0 || j == 0 || j == board[i].length - 1)
            return false;

        if (board[i][j] == '_')
            return true;

        board[i][j] = '_';

        boolean canFlipTop = tryToFlip(board, i - 1, j);
        boolean canFlipBottom = tryToFlip(board, i + 1, j);

        boolean canFlipLeft = tryToFlip(board, i, j - 1);
        boolean canFlipRight = tryToFlip(board, i, j + 1);

        if (canFlipTop && canFlipBottom && canFlipLeft && canFlipRight) {
            board[i][j] = 'X';
            return true;
        }
        // board[i][j] = 'O';
        return false;

    }

    public static void main(String[] args) {

        char[][] input = new char[][]{
                new char[]{'O', 'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'O', 'X', 'O'},
                new char[]{'X', 'O', 'X', 'O', 'X'},
                new char[]{'O', 'X', 'O', 'O', 'O'},
                new char[]{'X', 'X', 'O', 'X', 'O'},
        };

        M_130_SurroundedRegions instance = new M_130_SurroundedRegions();
        instance.solve(input);
        System.out.println(Arrays.deepToString(input));
    }
}
