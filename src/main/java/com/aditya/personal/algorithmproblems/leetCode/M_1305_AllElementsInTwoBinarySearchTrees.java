package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M_1305_AllElementsInTwoBinarySearchTrees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> root1Traversal = performInorderTraversal(root1);

        List<Integer> root2Traversal = performInorderTraversal(root2);

        List<Integer> toReturn = new ArrayList<>();

        int root1Pointer = 0;
        int root2Pointer = 0;

        for (int i = 0; i < root1Traversal.size() + root2Traversal.size(); i++) {

            if (root1Pointer >= root1Traversal.size()) {
                toReturn.add(root2Traversal.get(root2Pointer));
                root2Pointer++;

            } else if (root2Pointer >= root2Traversal.size()) {
                toReturn.add(root1Traversal.get(root1Pointer));
                root1Pointer++;

            } else if (root1Traversal.get(root1Pointer) <= root2Traversal.get(root2Pointer)) {

                toReturn.add(root1Traversal.get(root1Pointer));
                root1Pointer++;

            } else if (root1Traversal.get(root1Pointer) > root2Traversal.get(root2Pointer)) {
                toReturn.add(root2Traversal.get(root2Pointer));
                root2Pointer++;

            } else {
                throw new IllegalStateException("How did we reach here!");
            }
        }
        return toReturn;
    }

    private List<Integer> performInorderTraversal(TreeNode node) {

        List<Integer> toReturn = new ArrayList<>();

        if (node == null)
            return toReturn;

        Stack<TreeNode> toProcess = new Stack<>();

        TreeNode curr = node;

        while (curr != null || toProcess.size() > 0) {

            while (curr != null) {
                toProcess.push(curr);
                curr = curr.left;
            }

            curr = toProcess.pop();

            toReturn.add(curr.val);

            curr = curr.right;
        }

        return toReturn;
    }

}
