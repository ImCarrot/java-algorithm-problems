package com.aditya.personal.algorithmproblems.leetCode;

public class E_27_RemoveElement {

    public int removeElement(int[] nums, int val) {

        int firstPointer = -1;

        for (int i = 0; i < nums.length; i++) {

            if (firstPointer == -1 && nums[i] != val)
                continue;

            if (firstPointer == -1 && nums[i] == val) {
                firstPointer = i;
                continue;
            }

            if (nums[i] == val) // found duplicate
                continue;

            nums[firstPointer++] = nums[i];
            nums[i] = val;
        }

        if (firstPointer == -1)
            return nums.length;

        return firstPointer;

    }

}
