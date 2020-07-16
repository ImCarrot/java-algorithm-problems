package com.aditya.personal.algorithmproblems.leetCode;

public class M_142_LinkedListCycleII {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return fast;
            }
        }

        return null;
    }
}
