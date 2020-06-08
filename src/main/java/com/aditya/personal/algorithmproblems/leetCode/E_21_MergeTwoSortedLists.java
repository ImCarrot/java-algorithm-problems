package com.aditya.personal.algorithmproblems.leetCode;

public class E_21_MergeTwoSortedLists {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode headNode = null;
        ListNode tailNode = null;

        while (l1 != null && l2 != null) {

            ListNode toStore = null;

            if (l1.val <= l2.val) {
                toStore = l1;
                l1 = l1.next;
            } else {
                toStore = l2;
                l2 = l2.next;
            }

            if (headNode == null) {
                headNode = toStore;
            } else if (tailNode == null) {
                headNode.next = toStore;
                tailNode = headNode.next;
            } else {
                tailNode.next = toStore;
                tailNode = tailNode.next;
            }
        }

        while (l1 != null) {

            if (tailNode == null) {
                headNode.next = l1;
                tailNode = headNode.next;
            } else {
                tailNode.next = l1;
                tailNode = tailNode.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {

            if (tailNode == null) {
                headNode.next = l2;
                tailNode = headNode.next;
            } else {

                tailNode.next = l2;
                tailNode = tailNode.next;
            }
            l2 = l2.next;
        }

        return headNode;
    }

    public static void main(String[] args) {

        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2, four);
        ListNode one = new ListNode(1, two);

        ListNode four_2 = new ListNode(4);
        ListNode three = new ListNode(3, four_2);
        ListNode one_2 = new ListNode(1, three);

        E_21_MergeTwoSortedLists instance = new E_21_MergeTwoSortedLists();

        ListNode output = instance.mergeTwoLists(one, one_2); // expected: 1->1->2->3->4->4

        while (output != null) {
            System.out.print(output.val + "->");
            output = output.next;
        }
    }
}
