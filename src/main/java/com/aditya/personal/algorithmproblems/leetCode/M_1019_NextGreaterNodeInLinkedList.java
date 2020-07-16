package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class M_1019_NextGreaterNodeInLinkedList {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> A = new ArrayList<>();

        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);

        int[] res = new int[A.size()];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); ++i) {

            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);

            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

        ListNode input = new ListNode(2, new ListNode(1, new ListNode(5, null)));

        M_1019_NextGreaterNodeInLinkedList instance = new M_1019_NextGreaterNodeInLinkedList();
        System.out.println(Arrays.toString(instance.nextLargerNodes(input)));
    }
}
