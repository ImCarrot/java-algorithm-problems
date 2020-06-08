package com.aditya.personal.algorithmproblems.ctci.LinkedLists;


public class Intersection {

    public LinkedListNode<Integer> intersecting(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {

        if (first == null || second == null)
            return null;

        int sizeOne = this.getSize(first);
        int sizeTwo = this.getSize(second);

        if (sizeOne > sizeTwo)
            first = pushHeadToMatchDiff(first, sizeOne - sizeTwo);
        else if (sizeTwo > sizeOne)
            second = pushHeadToMatchDiff(second, sizeTwo - sizeOne);

        while (first != null) {

            if (first == second)
                return first;

            first = first.getNext();
            second = second.getNext();
        }

        return null;
    }


    public LinkedListNode<Integer> pushHeadToMatchDiff(LinkedListNode<Integer> head, int diff) {

        while (diff != 0) {
            head = head.getNext();
            diff -= 1;
        }
        return head;
    }


    public int getSize(LinkedListNode<Integer> headNode) {

        LinkedListNode<Integer> node = headNode;
        int size = 0;
        while (node != null) {
            size += 1;
            node = node.getNext();
        }
        return size;
    }

}
