package com.aditya.personal.algorithmproblems.leetCode;

public class E_1295_FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int count = 0;

        for (int n: nums) {
            if (countDigit(n) % 2 == 0)
                count += 1;
        }
        return count;
    }

    private int countDigit(int n)
    {
        return (int)Math.floor(Math.log10(n) + 1);
    }
}
