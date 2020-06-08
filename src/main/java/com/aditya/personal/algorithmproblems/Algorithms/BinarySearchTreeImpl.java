package com.aditya.personal.algorithmproblems.Algorithms;

public class BinarySearchTreeImpl {

    static class BinaryTreeNode<T extends Comparable<T>> {

        private final T data;

        private BinaryTreeNode<T> left;

        private BinaryTreeNode<T> right;

        private BinaryTreeNode<T> parent;

        public BinaryTreeNode(T item) {
            this.data = item;
        }
    }

    static class BinarySearchTree<T extends Comparable<T>> {

        private BinaryTreeNode<T> root;

        public void add(T item) {
            if (item == null)
                return;
            if (root == null) {
                root = new BinaryTreeNode<>(item);
                return;
            }

            BinaryTreeNode<T> parent = null;
            BinaryTreeNode<T> current = this.root;

            while (current != null) {
                parent = current;
                int comparisonResult = item.compareTo(current.data);
                if (comparisonResult < 0)
                    current = current.left;
                else if (comparisonResult > 0)
                    current = current.right;
            }

            int comparisonResult = item.compareTo(parent.data);

            if (comparisonResult > 0)
                parent.right = new BinaryTreeNode<>(item);
            else if (comparisonResult < 0)
                parent.left = new BinaryTreeNode<>(item);
        }

        public boolean isBalanced() {
            return this.isBinarySearchTree(this.root, null, null);
        }

        public boolean isBinarySearchTree(BinaryTreeNode<T> node, T min, T max) {

            if (node == null)
                return true;

            if ((min != null && node.data.compareTo(min) < 0) || (max != null && node.data.compareTo(max) > 0))
                return false;

            return isBinarySearchTree(node.left, min, node.data) && isBinarySearchTree(node.right, node.data, max);
        }
    }

    public static BinarySearchTree<Integer> convert(int... arr) {

        if (arr == null || arr.length == 0)
            return null;

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int mid = arr.length / 2;

        // tree.add(arr[mid]);

        for (int i = mid; i >= 0; i--) {

            tree.add(arr[i]); // add left

            int postIndex = arr.length - i;

            if (i == postIndex || postIndex == arr.length)
                continue;

            tree.add(arr[postIndex]);  // add right
        }

        return tree;
    }

    public static void main(String[] args) {
        convert(1, 2, 3, 4, 5, 6, 7, 8);
    }

// 122, 673, 260

}
