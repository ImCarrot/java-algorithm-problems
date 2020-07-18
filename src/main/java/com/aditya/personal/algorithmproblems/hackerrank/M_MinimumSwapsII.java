package com.aditya.personal.algorithmproblems.hackerrank;

import javafx.util.Pair;

import java.util.ArrayList;

public class M_MinimumSwapsII {


    // Complete the minimumSwaps function below.
    public static int minimumSwaps(int[] arr) {
        int n = arr.length;

        ArrayList<Pair<Integer, Integer>> positions = new ArrayList<>();

        for (int i = 0; i < n; i++)
            positions.add(new Pair<>(arr[i], i));

        positions.sort((o1, o2) -> {
            if (o2.getKey() > o1.getKey())
                return -1;

            else if (o1.getKey().equals(o2.getKey()))
                return 0;

            else
                return 1;
        });

        boolean[] vis = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (vis[i] || positions.get(i).getValue() == i)
                continue;

            int cycle_size = 0;
            int j = i;

            while (!vis[j]) {
                vis[j] = true;

                j = positions.get(j).getValue();
                cycle_size++;
            }

            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
    }

}
