package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class M_215_KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int number : nums)
            maxHeap.add(number);

        int lastPulled = -1;

        while (k != 0 && !maxHeap.isEmpty()) {
            lastPulled = maxHeap.poll();
            k--;
        }

        return lastPulled;
    }

    public static void main(String[] args) {
        M_215_KthLargestElementInArray instance = new M_215_KthLargestElementInArray();

        System.out.println(instance.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // expected 5

        System.out.println(instance.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // expected 4
    }
}
