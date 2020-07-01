package com.aditya.personal.algorithmproblems.leetCode;

public class M_5455_MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {

        int totalFlowers = m * k;

        if (bloomDay.length < totalFlowers)
            return -1;

        if (m == 0)
            return 0;

        int maxDays = Integer.MIN_VALUE;
        int minDays = Integer.MAX_VALUE;
        for (int n : bloomDay) {
            maxDays = Math.max(maxDays, n);
            minDays = Math.min(minDays, n);
        }

        if (maxDays == minDays)
            return maxDays;


        int minDaysNeeded = performBinary(bloomDay, m, k, minDays, maxDays);

        if (minDaysNeeded == Integer.MAX_VALUE)
            return -1;

        return minDaysNeeded;
    }

    private int performBinary(int[] bloomDay, int bouquetToMake, int flowerCount, int lp, int rp) {

        if (lp > rp)
            return Integer.MAX_VALUE;

        int currentDay = lp + (rp - lp) / 2;

        int[] simulation = simulate(bloomDay, currentDay);

        int bouquetCount = make(simulation, flowerCount);

        if (bouquetCount < bouquetToMake)
            return performBinary(bloomDay, bouquetToMake, flowerCount, currentDay + 1, rp);

        return Math.min(currentDay, performBinary(bloomDay, bouquetToMake, flowerCount, lp, currentDay - 1));

    }

    private int[] simulate(int[] bloomDay, int day) {

        int[] copy = bloomDay.clone();
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] <= day)
                copy[i] = 0;
        }
        return copy;
    }

    private int make(int[] stats, int flowerCount) {

        int count = 0;

        for (int i = 0; i < stats.length; i += flowerCount) {

            if (stats[i] != 0) {
                i = i - flowerCount + 1;
                continue;
            }


            int matches = 0;

            for (int j = i; j <= i + flowerCount; j++) {

                if (j == stats.length)
                    break;

                if (stats[j] != 0) {
                    i = j - flowerCount + 1;
                    break;
                }

                matches++;

            }

            if (matches >= flowerCount)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        M_5455_MinimumNumberOfDaysToMakeMBouquets instance = new M_5455_MinimumNumberOfDaysToMakeMBouquets();

        System.out.println(instance.minDays(new int[]{81, 23, 10, 90, 68, 43, 81, 10, 92, 65, 47, 57, 51, 74, 61, 79, 18, 52, 74, 90}, 2, 7));

    }

}
