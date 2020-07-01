package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Math.min;

public class M_1477_FindTwoNonOverlappingSubArraysEachWithTargetSum {

    public int minSumOfLengths2(int[] arr, int target) {

        int n = arr.length;

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int sum = 0, start = 0, ans = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            while (sum > target) {

                sum -= arr[start];
                start++;
            }

            if (sum == target) {
                if (start > 0 && best[start - 1] != Integer.MAX_VALUE) {
                    ans = min(ans, best[start - 1] + i - start + 1);
                }
                bestSoFar = min(bestSoFar, i - start + 1);

                if (bestSoFar == 2)
                    System.out.println("");
            }


            best[i] = bestSoFar;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minSumOfLengths(int[] arr, int target) {

        PriorityQueue<Integer> leastSizes = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > target)
                continue;

            int currentSum = 0;
            List<Integer> matched = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {

                matched.add(arr[j]);
                currentSum += arr[j];

                if (currentSum == target) {

                    int currentSize = matched.size();

                    if (leastSizes.size() < 2) {
                        leastSizes.add(currentSize);
                        i = j; // increment i to the current value of j
                        break;
                    }

                    int currentMax = leastSizes.peek();

                    // meaning found shorter
                    if (currentMax > currentSize) {
                        leastSizes.poll();
                        leastSizes.add(currentSize);
                        i = j; // increment i to the current value of j
                        break;
                    }
                    break;
                }

                if (currentSum > target) {
                    break;
                }
            }
        }

        if (leastSizes.size() < 2)
            return -1;

        //noinspection ConstantConditions
        return leastSizes.poll() + leastSizes.poll();

    }

    public static void main(String[] args) {
        M_1477_FindTwoNonOverlappingSubArraysEachWithTargetSum instance = new M_1477_FindTwoNonOverlappingSubArraysEachWithTargetSum();

        System.out.println(instance.minSumOfLengths(new int[]{78, 18, 1, 94, 1, 1, 1, 29, 58, 3, 4, 1, 2, 56, 17, 19, 4, 1, 63, 2, 16, 11, 1, 1, 2, 1, 25, 62, 10, 69, 12, 7, 1, 6, 2, 92, 4, 1, 61, 7, 26, 1, 1, 1, 67, 26, 2, 2, 70, 25, 2, 68, 13, 4, 11, 1, 34, 14, 7, 37, 4, 1, 12, 51, 25, 2, 4, 3, 56, 21, 7, 8, 5, 93, 1, 1, 2, 55, 14, 25, 1, 1, 1, 89, 6, 1, 1, 24, 22, 50, 1, 28, 9, 51, 9, 88, 1, 7, 1, 30, 32, 18, 12, 3, 2, 18, 10, 4, 11, 43, 6, 5, 93, 2, 2, 68, 18, 11, 47, 33, 17, 27, 56, 13, 1, 2, 29, 1, 17, 1, 10, 15, 18, 3, 1, 86, 7, 4, 16, 45, 3, 29, 2, 1, 1, 31, 19, 18, 16, 12, 1, 56, 4, 35, 1, 1, 36, 59, 1, 1, 16, 58, 18, 4, 1, 43, 31, 15, 6, 1, 1, 6, 49, 27, 12, 1, 2, 80, 14, 2, 1, 21, 32, 18, 15, 11, 59, 10, 1, 14, 3, 3, 7, 15, 4, 55, 4, 1, 12, 4, 1, 1, 53, 37, 2, 5, 72, 3, 6, 10, 3, 3, 83, 8, 1, 5}, 97));
    }

}
