package com.aditya.personal.algorithmproblems.leetCode;

public class M_287_FindDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    public static void main(String[] args) {
        M_287_FindDuplicateNumber instance = new M_287_FindDuplicateNumber();
        System.out.println(instance.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

}
