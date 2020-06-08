package com.aditya.personal.algorithmproblems.ctci.LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    public boolean equals(Object obj) {
        return this == obj;
    }

    public <T extends Comparable<T>> void removeDuplicates(LinkedListNode<T> node) {

        if (node == null)
            return;

        Set<T> used = new HashSet<>();

        LinkedListNode<T> previousNode = null;

        while (node != null) {

            if (used.contains(node.getData())) {
                previousNode.setNext(node.getNext());
            } else {
                used.add(node.getData());
                previousNode = node;
            }

            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        // 107, 223, 673
    }

}
