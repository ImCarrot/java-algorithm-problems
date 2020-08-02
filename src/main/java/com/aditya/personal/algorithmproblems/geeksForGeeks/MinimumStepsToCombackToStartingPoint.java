package com.aditya.personal.algorithmproblems.geeksForGeeks;

public class MinimumStepsToCombackToStartingPoint {

    public static int getMoves(int size, int start, int step) {

       int moves = 0;

        int current = start;
        boolean first = true;

        while (current != start || first) {

            if (first)
                first = false;

            current = current + step;
            moves++;

            if (current > size) {
                current = current - size;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        System.out.println(getMoves(9, 2, 6));
    }
}
