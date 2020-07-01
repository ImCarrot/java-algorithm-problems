package com.aditya.personal.algorithmproblems.hackerrank;

public class RepeatedString {

    static void minimumBribes2(int[] q) {

        int totalBribes = 0;

        for (int i = 1; i <= q.length; i++) {

            int element = q[i - 1];

            int diff = element - i;

            if (diff < 0)
                continue; // because bribe was accepted.

            if (diff > 2) {
                System.out.println("Too chaotic");
                return;
            }
            totalBribes += diff;
        }
        System.out.println(totalBribes);

    }

    static void minimumBribes(int[] q) {

        int totalBribes = 0;

        int[] Q = new int[q.length];
        for (int i = 0; i < q.length; i++)
            Q[i] = q[i]- 1;

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
//        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 4)));
    }

}
