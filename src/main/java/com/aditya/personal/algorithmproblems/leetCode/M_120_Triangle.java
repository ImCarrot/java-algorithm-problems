package com.aditya.personal.algorithmproblems.leetCode;

import java.util.*;

public class M_120_Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                int sum = triangle.get(i - 1).get(j) + Math.min(triangle.get(i).get(j), triangle.get(i).get(j + 1));

                triangle.get(i - 1).set(j, sum);
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        //noinspection ArraysAsListWithZeroOrOneArgument
        System.out.println(minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3))));
    }
}
