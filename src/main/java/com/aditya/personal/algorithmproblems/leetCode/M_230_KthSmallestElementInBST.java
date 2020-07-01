package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Stack;

public class M_230_KthSmallestElementInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {

        if (root == null)
            return -1;

        Stack<TreeNode> processStack = new Stack<>();

        TreeNode current = root;

        int lastTraversed = -1;

        while (current != null || !processStack.isEmpty()) {

            while(current != null) {
                processStack.push(current);
                current = current.left;
            }

            current = processStack.pop();
            lastTraversed = current.val;
            k--;
            if (k == 0)
                break;
            current = current.right;
        }

        return lastTraversed;

    }

}
