package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;
import java.util.Stack;

public class H_239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {


        Stack<Integer> currentMax = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (currentMax.isEmpty())
                currentMax.push(nums[i]);
            else
                currentMax.push(Math.max(currentMax.peek(), nums[i]));
        }

        Stack<Integer> leftToRight = new Stack<>();
        for (int i = nums.length - 1; i - k + 1 >= 0; i--) {

            if (currentMax.isEmpty())
                break;

            leftToRight.push(currentMax.pop());
        }

        int[] output = new int[leftToRight.size()];

        for (int i = 0; i < output.length; i++)
            output[i] = leftToRight.pop();

        return output;
    }

    public static void main(String[] args) {
        H_239_SlidingWindowMaximum instance = new H_239_SlidingWindowMaximum();
        System.out.println(Arrays.toString(instance.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
