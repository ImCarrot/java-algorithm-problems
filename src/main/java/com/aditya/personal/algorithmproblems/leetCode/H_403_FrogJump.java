package com.aditya.personal.algorithmproblems.leetCode;

public class H_403_FrogJump {

    public boolean canCross(int[] stones) {

        if (stones.length == 0)
            return false;

        if (stones.length == 1)
            return true;

        int k = 0;
        for (int i = 0; i < stones.length - 1; i++) {

            int diff = stones[i + 1] - stones[i];
            int nextDiff = i < stones.length - 2 ? stones[i + 2] - stones[i] : -1;
            if (k + 1 == diff || k == diff || k - 1 == diff) {
                k = diff;
                continue;
            } 
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        H_403_FrogJump instance = new H_403_FrogJump();
        System.out.println(instance.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

}
