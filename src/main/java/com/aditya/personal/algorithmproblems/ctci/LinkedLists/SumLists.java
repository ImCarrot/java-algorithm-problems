package com.aditya.personal.algorithmproblems.ctci.LinkedLists;


import java.util.Stack;

public class SumLists {

    public static LinkedListNode<Integer> sumLists(LinkedListNode<Integer> headLeft, LinkedListNode<Integer> headRight) {

        if (headLeft == null || headRight == null)
            return null;

        Stack<Integer> leftNumbers = new Stack<>();
        while (headLeft != null) {
            leftNumbers.push(headLeft.getData());
            headLeft = headLeft.getNext();
        }

        Stack<Integer> rightNumbers = new Stack<>();
        while (headRight != null) {
            rightNumbers.push(headRight.getData());
            headRight = headRight.getNext();
        }

        StringBuilder leftNumberBuilder = new StringBuilder();
        while (!leftNumbers.empty()) {
            leftNumberBuilder.append(leftNumbers.pop());
        }

        int leftNumber = Integer.parseInt(leftNumberBuilder.toString());


        StringBuilder rightNumberBuilder = new StringBuilder();
        while (!rightNumbers.empty()) {
            rightNumberBuilder.append(rightNumbers.pop());
        }

        int rightNumber = Integer.parseInt(rightNumberBuilder.toString());

        int output = leftNumber + rightNumber;

        String outString = String.valueOf(output);

        LinkedListNode<Integer> outputHead = null;
        LinkedListNode<Integer> outputTail = null;

        for (int i = outString.length() - 1; i >= 0; i--) {

            if (outputHead == null) {
                outputHead = new LinkedListNode<>(outString.charAt(i) - '0');
                continue;
            }

            if (outputTail == null) {
                outputTail = new LinkedListNode<>(outString.charAt(i) - '0');
                outputHead.setNext(outputTail);
            }

            LinkedListNode<Integer> newTail = new LinkedListNode<>(outString.charAt(i) - '0');
            outputTail.setNext(newTail);
            outputTail = newTail;
        }

        return outputHead;
    }

}
