package com.aditya.personal.algorithmproblems.ctci.LinkedLists;


public class Partition {

    public static void deleteMiddleNode(LinkedListNode<Integer> headNode, Integer partitionValue) {

        if (headNode == null || headNode.getNext() == null || partitionValue == null)
            return;

        LinkedListNode<Integer> partitionMarker = null; // the first node that's greater than or equals the partitionValue
        LinkedListNode<Integer> currentNode = headNode;

        LinkedListNode<Integer> chainTail = null;
        LinkedListNode<Integer> prevNode = null;
        while (currentNode != null) {

            int comparisonResult = currentNode.getData().compareTo(partitionValue);

            // this means the partition value wasn't found
            if (partitionMarker == null) {

                if (comparisonResult < 0) {
                    chainTail = currentNode;
                    prevNode = currentNode;
                    currentNode = currentNode.getNext();
                    continue;
                }

                partitionMarker = currentNode;
                prevNode = currentNode;
                currentNode = currentNode.getNext();
                continue;
            }


            if (comparisonResult >= 0) {
                prevNode = currentNode;
                currentNode = currentNode.getNext();
                continue;
            }


            LinkedListNode<Integer> nextNode = currentNode.getNext(); // so that we don't loose it

            if (chainTail == null)
                chainTail = currentNode;
            else
                chainTail.setNext(currentNode);

            chainTail = chainTail.getNext();
            chainTail.setNext(partitionMarker);
            prevNode.setNext(nextNode);
            currentNode = nextNode;
        }
    }
}
