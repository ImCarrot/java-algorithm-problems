package com.aditya.personal.algorithmproblems.leetCode;

public class H_124_BinaryTreeMaximumPathSum {

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


    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculatePathSum(root);

        return globalMax;
    }

    private int calculatePathSum(TreeNode node) {

        if (node == null)
            return 0;

        int leftSum = Math.max(calculatePathSum(node.left), 0);

        int rightSum = Math.max(calculatePathSum(node.right), 0);

        int bothChildSum = leftSum + rightSum + node.val;

        int childMax = Math.max(leftSum, rightSum);

        // int currentMax = Math.max(childMax + node.val, bothChildSum);

        globalMax = Math.max(globalMax, bothChildSum);

        return childMax + node.val;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1, two, three);

        H_124_BinaryTreeMaximumPathSum instance = new H_124_BinaryTreeMaximumPathSum();
        System.out.println(instance.maxPathSum(one));
    }

}
