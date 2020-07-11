package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;

public class H_295_FindMedianFromDataStream {

    int[] dataStore;
    int toPlace = 0;

    /** initialize your data structure here. */
    public H_295_FindMedianFromDataStream() {
        dataStore = new int[1];
        Arrays.fill(dataStore, Integer.MAX_VALUE);
    }

    public void addNum(int num) {

        if (toPlace == 0) {
            dataStore[toPlace++] = num;
            return;
        }

        if (toPlace == dataStore.length) {
            int[] newDataStore = new int[dataStore.length * 2];

            for (int i = 0; i < newDataStore.length; i++) {
                if (i < dataStore.length)
                    newDataStore[i] = dataStore[i];
                else
                    newDataStore[i] = Integer.MAX_VALUE;
            }

            this.dataStore = newDataStore;
        }

        if (num == 4)
            System.out.println("");

        int idealIndex = findIdealIndex(num, 0, toPlace - 1);

        if (toPlace - idealIndex >= 0)
            System.arraycopy(dataStore, idealIndex, dataStore, idealIndex + 1, toPlace - idealIndex);

        dataStore[idealIndex] = num;
        toPlace++;
    }

    private int findIdealIndex(int number, int start, int end) {

        if (start >= end) {
            if (number > dataStore[start])
                return start + 1;
            else
                return start;
        }

        int mid = start + (end - start) / 2;

        if (dataStore[mid] < number) {
            if (dataStore[mid + 1] > number)
                return mid + 1;
            return findIdealIndex(number, mid + 1, end);
        }

        else if (dataStore[mid] > number)
            return findIdealIndex(number, start, mid - 1);

        return mid;

    }

    public double findMedian() {

        if (toPlace % 2 != 0)
            return dataStore[toPlace / 2];

        int mid = toPlace / 2;

        return ((double)dataStore[mid] + (double)dataStore[mid - 1]) / 2;
    }

    public static void main(String[] args) {
        H_295_FindMedianFromDataStream instance = new H_295_FindMedianFromDataStream();

        instance.addNum(-1);
        System.out.println(instance.findMedian());
        instance.addNum(-2);
        System.out.println(instance.findMedian());
        instance.addNum(-3);
        System.out.println(instance.findMedian());
        instance.addNum(-4);
        System.out.println(instance.findMedian());
        instance.addNum(-5);
        System.out.println(instance.findMedian());
         // -> 1.5
    }

}
