package com.aditya.personal.algorithmproblems.leetCode;

public class M_2_AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 != null)
            return l2;

        if (l2 == null && l1 != null)
            return l1;

        ListNode outHead = null;
        ListNode outPrev = null;
        ListNode outPointer = null;

        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;

        int carry = 0;
        while (l1Pointer != null || l2Pointer != null) {

            int l1Val = l1Pointer == null ? 0 : l1Pointer.val;
            int l2Val = l2Pointer == null ? 0 : l2Pointer.val;

            int sum = l1Val + l2Val + carry;

            int outVal = sum % 10;

            carry = sum / 10;

            outPointer = new ListNode(outVal);

            if (outPrev == null)
                outHead = outPointer;
            else
                outPrev.next = outPointer;

            outPrev = outPointer;

            if (l1Pointer != null)
                l1Pointer = l1Pointer.next;
            if (l2Pointer != null)
                l2Pointer = l2Pointer.next;
        }

        if (carry != 0) {
            outPointer.next = new ListNode(carry);
        }

        return outHead;
    }

}
