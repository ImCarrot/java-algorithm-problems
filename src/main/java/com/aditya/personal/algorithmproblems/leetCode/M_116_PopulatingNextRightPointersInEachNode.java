package com.aditya.personal.algorithmproblems.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class M_116_PopulatingNextRightPointersInEachNode {


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connectRecursive(Node root) {

        if (root != null && root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
            connectRecursive(root.left);
            connectRecursive(root.right);
        }
        return root;

    }

    public Node connectApproachLevelOrder(Node root) {

        if (root == null)
            return null;

        Queue<Node> toProcess = new LinkedList<>();

        toProcess.add(root);

        while (!toProcess.isEmpty()) {

            int size = toProcess.size();

            for (int i = size; i > 0; i--) {
                Node current = toProcess.poll();

                if (i == 1) {
                    current.next = null;
                } else
                    current.next = toProcess.peek();

                if (current.left != null)
                    toProcess.add(current.left);

                if (current.right != null)
                    toProcess.add(current.right);
            }
        }
        return root;
    }

}
