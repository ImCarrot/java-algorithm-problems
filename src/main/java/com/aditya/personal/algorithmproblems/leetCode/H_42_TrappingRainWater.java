package com.aditya.personal.algorithmproblems.leetCode;

public class H_42_TrappingRainWater {

    public static int trap(int[] heights) {

        if (heights.length == 0)
            return 0;

        int[] leftHeights = new int[heights.length];

        leftHeights[0] = heights[0];

        for (int i = 1; i < heights.length; i++)
            leftHeights[i] = Math.max(leftHeights[i-1], heights[i]);

        int[] rightHeights = new int[heights.length];

        rightHeights[heights.length - 1] = heights[heights.length - 1];

        for (int i = heights.length - 2; i >= 0; i--)
            rightHeights[i] = Math.max(rightHeights[i+1], heights[i]);

        int trapped = 0;

        for (int i = 0; i < heights.length; i++)
            trapped += (Math.min(leftHeights[i], rightHeights[i]) - heights[i]);

        return trapped;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
