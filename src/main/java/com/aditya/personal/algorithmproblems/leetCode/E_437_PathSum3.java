package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;

public class E_437_PathSum3 {

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

    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        pathSumCount(root, 0, sum, sumMap);
        return count;

    }


    public void pathSumCount(TreeNode node, int sum, int target, Map<Integer, Integer> sumMap) {
        if (node == null)
            return;

        sum += node.val;

        if (sumMap.containsKey(sum - target)) {
            count += sumMap.get(sum - target);
        }
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        pathSumCount(node.left, sum, target, sumMap);
        pathSumCount(node.right, sum, target, sumMap);
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) - 1);
        sum -= node.val;
    }

    public static void main(String[] args) {
        E_437_PathSum3 instance = new E_437_PathSum3();

        TreeNode one = new TreeNode(1);
        TreeNode minusTwo = new TreeNode(-2);
        TreeNode three = new TreeNode(3);

        TreeNode parentThree = new TreeNode(3, three, minusTwo);
        TreeNode two = new TreeNode(2, null, one);

        TreeNode five = new TreeNode(5, parentThree, two);

        TreeNode eleven = new TreeNode(11);
        TreeNode minusThree = new TreeNode(-3, null, eleven);

        TreeNode ten = new TreeNode(10, five, minusThree);

        System.out.println(instance.pathSum(ten, 8));
    }
}
