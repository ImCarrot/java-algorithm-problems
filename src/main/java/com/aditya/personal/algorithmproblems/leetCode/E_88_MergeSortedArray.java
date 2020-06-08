package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class E_88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] first = new int[m];
        if (m >= 0)
            System.arraycopy(nums1, 0, first, 0, m);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (first[i] <= nums2[j]) {
                nums1[k] = first[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            nums1[k] = first[i];
            i++;
            k++;
        }

        while (j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        E_88_MergeSortedArray instance = new E_88_MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        instance.merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1)); // expected: [1, 2, 2, 3, 5, 6]
    }
}
