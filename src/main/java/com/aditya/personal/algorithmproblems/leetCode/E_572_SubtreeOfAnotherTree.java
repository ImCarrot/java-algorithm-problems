package com.aditya.personal.algorithmproblems.leetCode;

public class E_572_SubtreeOfAnotherTree {

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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s !=null && (isSame(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t));
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
