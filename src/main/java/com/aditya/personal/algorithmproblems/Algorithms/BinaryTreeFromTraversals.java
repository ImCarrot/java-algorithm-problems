package com.aditya.personal.algorithmproblems.Algorithms;

import java.util.ArrayList;
import java.util.Collection;

public class BinaryTreeFromTraversals {

    static class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;

        return this.buildSubTree(preorder, inorder, 0, inorder.length, 0);
    }

    public TreeNode buildSubTree(int[] preOrder, int[] inOrder, int iStartIndex, int iEndIndex, int pStart) {

        if (iStartIndex >= iEndIndex || pStart >= preOrder.length)
            return null;

        TreeNode root = new TreeNode(preOrder[pStart]);

        int indexRoot = -1;

        for (int i = iStartIndex; i <= iEndIndex; i++) {
            if (root.val == inOrder[i]) {
                indexRoot = i;
                break;
            }
        }



        root.left = this.buildSubTree(preOrder, inOrder, iStartIndex, indexRoot, pStart + 1);
        root.right = this.buildSubTree(preOrder, inOrder, indexRoot + 1, iEndIndex, pStart + indexRoot - iStartIndex + 1);
        return root;
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7};
        int[] i = {8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7};

        TreeNode out = new BinaryTreeFromTraversals().buildTree(p, i);

        System.out.println("");
    }
}
