package com.aditya.personal.algorithmproblems.leetCode;

public class M_287_FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        if (nums.length <= 1)
            return -1;

        if (nums.length == 2)
            return nums[0] == nums[1] ? nums[0] : -1;

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow)
        {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

}
