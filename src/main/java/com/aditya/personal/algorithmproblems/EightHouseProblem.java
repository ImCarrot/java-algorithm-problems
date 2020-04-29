package com.aditya.personal.algorithmproblems;

import java.util.ArrayList;
import java.util.List;

public class EightHouseProblem {

    private static final int ACTIVE = 1;
    private static final int INACTIVE = 0;

    public static List<Integer> cellCompete(int[] states, int days) {

        int[] dayOutput = new int[states.length];

        System.arraycopy(states, 0, dayOutput, 0, states.length);

        while (days > 0) {

            for (int i = 0; i < states.length; i++) {

                // since at the edge the unoccupied is INACTIVE
                if (i == 0) {
                    if (states[1] == INACTIVE)
                        dayOutput[0] = INACTIVE;
                    continue;
                }

                if (i == 7) {
                    if (states[6] == INACTIVE)
                        dayOutput[7] = INACTIVE;
                    continue;
                }

                // check both sides to see if they both are ACTIVE or INACTIVE, basically same
                if (states[i - 1] == states[i + 1]) {
                    dayOutput[i] = INACTIVE;
                    continue;
                }

                dayOutput[i] = ACTIVE;
            }
            System.arraycopy(dayOutput, 0, states, 0, dayOutput.length);
            days--;
        }

        List<Integer> toReturn = new ArrayList<>();

        for (int element : states)
            toReturn.add(element);
        return toReturn;

    }


    public static void main(String[] args) {


        /*
        Problem Statement:

        Eight houses, represented as a cells, are arranged as a straight line. Each days every cells competes with
        adjacent cells. An integer value 1 represents an active cell and a value of 0 represent an inactive cell.
        if the neighbour on both the sides of the cell are both active or inactive, the cell become inactive in the
        next day, otherwise the become active. The two cells on each or have a single adjacent cell, so assume that
        the unoccupied space in the opposite side is an inactive cell. even after updating the cell state, consider
        its previous state when updating the state of others cells. The state information of the cells should be
        updated simultaneously. Write an algorithm to output the state of the cell after the given number of the cell

        Input:
        the input to the function consist on two arguments: states, a list of integer representing the current
        state of cells; days, an integer representing the number of days output

        Output:
        Return a list of integers representing the state of the cells after the given number of days.

        Note: the elements of the list states contains 0s or 1s only
         */

        int[] TestCase1 = {1, 0, 0, 0, 0, 1, 0, 0};
        int[] TestCase2 = {1, 1, 1, 0, 1, 1, 1, 1};

        System.out.println(cellCompete(TestCase1, 1)); // Expected: 0,1,0,0,1,0,1,0
        System.out.println(cellCompete(TestCase2, 2)); // Expected: 0,0,0,0,0,1,1,0

    }
}
