package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M_103_BinaryTreeZigzagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> toReturn = new ArrayList<>();

        if (root == null)
            return toReturn;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flipNext = false;
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();

                if (flipNext)
                    currentLevel.add(0, current.val);
                else
                    currentLevel.add(current.val);

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
            toReturn.add(currentLevel);
            flipNext = !flipNext;
        }
        return toReturn;
    }

}
