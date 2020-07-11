package com.aditya.personal.algorithmproblems.leetCode;

public class M_98_ValidateBinarySearchTree {

    public class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode node, Integer lower, Integer upper) {

        if (node == null)
            return true;

        if (lower != null && lower >= node.val)
            return false;

        if (upper != null && upper <= node.val)
            return false;

        return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
    }

}
