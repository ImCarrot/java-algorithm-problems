package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KDistantNodesFromRoot {

    public static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static List<Integer> kDistanceFrom(Node root, int k) {

        if (root == null || (k > 1 && root.right == null && root.left == null))
            return null;

        Queue<Node> toProcess = new LinkedList<>();

        toProcess.add(root);

        int currentLevel = 0;
        while (!toProcess.isEmpty() && currentLevel < k) {

            int size = toProcess.size();

            while (size > 0) {

                Node current = toProcess.poll();

                if (current.left != null)
                    toProcess.add(current.left);

                if (current.right != null)
                    toProcess.add(current.right);

                size--;
            }
            currentLevel++;
        }

        if (toProcess.isEmpty())
            return null;

        List<Integer> toReturn = new ArrayList<>();

        while (!toProcess.isEmpty()) {
            toReturn.add(toProcess.poll().data);
        }

        return toReturn;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);

        System.out.println(kDistanceFrom(root, 10));
    }
}
