package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Stack;

public class E_155_MinStack {

    int[] data;
    int[] mins;

    int filledSize = 0;

    /** initialize your data structure here. */
    public E_155_MinStack() {

        data = new int[4];
        mins = new int[4];
    }

    public void push(int x) {

        if (filledSize == data.length) {

            int[] toCopy = new int[data.length * 2];
            int[] newMins = new int[mins.length * 2];
            for (int i = 0; i < data.length; i++) {
                toCopy[i] = data[i];
                newMins[i] = mins[i];
            }

            data = toCopy;
            mins = newMins;
        }

        data[filledSize] = x;
        mins[filledSize] = filledSize == 0 ? x : Math.min(mins[filledSize - 1], data[filledSize]);
        filledSize++;
    }

    public void pop() {
        filledSize--;
        mins[filledSize] = 0;
        data[filledSize] = 0;

    }

    public int top() {
        return data[filledSize - 1];
    }

    public int getMin() {
        return mins[filledSize - 1];
    }

    public static void main(String[] args) {
        E_155_MinStack minStack = new E_155_MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }
}
