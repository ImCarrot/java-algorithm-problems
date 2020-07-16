package com.aditya.personal.algorithmproblems.leetCode;

public class H_25_ReverseNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {

            int steps = k - 1;

            ListNode toSwap = current;
            ListNode swapPrev = null;

            while(steps > 0 && toSwap != null) {
                swapPrev = toSwap;
                toSwap = toSwap.next;
                steps--;
            }

            if (toSwap == null)
                return head;

            if (swapPrev == current) {
                // TODO: Handle this case
                continue;
            }

            if (previous != null)
                previous.next = toSwap;

            if (swapPrev != null)
                swapPrev.next = current;

            ListNode swapNext = toSwap.next;

            toSwap.next = current.next;
            current.next = swapNext;

            previous = current;
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        H_25_ReverseNodesInKGroup instance = new H_25_ReverseNodesInKGroup();
        instance.reverseKGroup(input, 3);
        System.out.println("Done!");
    }

}
