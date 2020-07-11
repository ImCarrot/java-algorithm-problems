package com.aditya.personal.algorithmproblems.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class E_104_MaximumDepthOfBinaryTree {


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

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> processQueue = new LinkedList<>();

        processQueue.add(root);

        int totalLevels = 0;

        while (!processQueue.isEmpty()) {

            totalLevels++;

            int size = processQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = processQueue.poll();

                if (current.left != null)
                    processQueue.add(current.left);

                if (current.right != null)
                    processQueue.add(current.right);
            }
        }
        return totalLevels;
    }
}
