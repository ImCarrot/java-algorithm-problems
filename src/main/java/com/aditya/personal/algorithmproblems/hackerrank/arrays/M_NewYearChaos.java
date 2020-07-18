package com.aditya.personal.algorithmproblems.hackerrank.arrays;

public class M_NewYearChaos {

    static void minimumBribes(int[] q) {

        int totalBribes = 0;

        int[] Q = new int[q.length];
        for (int i = 0; i < q.length; i++)
            Q[i] = q[i] - 1;

        for (int i = 0; i < Q.length; i++) {

            int P = Q[i];

            if (P - i > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(P - 1, 0); j < i; j++) {
                if (Q[j] > P)
                    totalBribes++;
            }
        }
        System.out.println(totalBribes);
    }

    public static void main(String[] args) {
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
    }
}
