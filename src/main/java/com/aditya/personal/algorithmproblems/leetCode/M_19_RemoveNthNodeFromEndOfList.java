package com.aditya.personal.algorithmproblems.leetCode;

public class M_19_RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null)
            return null;

        ListNode nPointer = head;
        ListNode advancedPointer = head;
        ListNode previousNode = null;

        while (n > 0 && advancedPointer != null) {
            advancedPointer = advancedPointer.next;
            n--;
        }

        if (advancedPointer == null) {
            head = head.next;
            return head;
        }

        while(advancedPointer != null) {
            previousNode = nPointer;
            nPointer = nPointer.next;
            advancedPointer = advancedPointer.next;
        }

        previousNode.next = nPointer.next;

        return head;
    }
}
