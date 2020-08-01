package com.aditya.personal.algorithmproblems.hackerrank.sorting;

import java.util.Arrays;

public class E_MarkAndToys {

    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);

        int currentCost = 0;
        int toyCount = 0;
        for (int price : prices) {

            if (currentCost + price <= k) {
                currentCost += price;
                toyCount++;
            } else
                break;
        }
        return toyCount;
    }

}
