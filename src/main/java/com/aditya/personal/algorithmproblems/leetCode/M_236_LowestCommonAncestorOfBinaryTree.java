package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M_236_LowestCommonAncestorOfBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> chainP = fetchChain(root, p);

        List<TreeNode> chainQ = fetchChain(root, q);

        System.out.println(chainP.get(0).val);
        System.out.println(chainQ.get(0).val);

        for (int i = Math.min(chainP.size(), chainQ.size()) - 1; i >= 0; i--) {
            if (chainP.get(i).val == chainQ.get(i).val)
                return chainP.get(i);
        }
        return null;

    }

    private List<TreeNode> fetchChain(TreeNode rootNode, TreeNode target) {

        Stack<TreeNode> processStack = new Stack<>();

        processStack.push(rootNode);

        while (!processStack.isEmpty()) {

            TreeNode current = processStack.pop();

            if (current.val == target.val)
                break;

            if (current.right != null)
                processStack.push(current.right);

            if (current.left != null)
                processStack.push(current.left);
        }

        // meaning element not found
        if (processStack.isEmpty())
            return null;

        List<TreeNode> chain = new ArrayList<>();
        while (!processStack.isEmpty())
            chain.add(processStack.pop());

        return chain;
    }

    public static void main(String[] args) {

        TreeNode six = new TreeNode(6);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);


        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        two.left = seven;
        two.right = four;

        TreeNode five = new TreeNode(5);
        five.left = six;
        five.right = two;

        TreeNode one = new TreeNode(1);
        one.left = zero;
        one.right = eight;

        TreeNode three = new TreeNode(3);
        three.left = five;
        three.right = one;

        M_236_LowestCommonAncestorOfBinaryTree instance = new M_236_LowestCommonAncestorOfBinaryTree();
        System.out.println(instance.lowestCommonAncestor(three, five, one));
    }

}
