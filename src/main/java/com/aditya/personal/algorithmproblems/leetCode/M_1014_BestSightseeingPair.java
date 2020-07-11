package com.aditya.personal.algorithmproblems.leetCode;

public class M_1014_BestSightseeingPair {

    public static int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int cur = 0;

        for (int a : A) {
            res = Math.max(res, cur + a);
            cur = Math.max(cur, a) - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(M_1014_BestSightseeingPair.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

}
