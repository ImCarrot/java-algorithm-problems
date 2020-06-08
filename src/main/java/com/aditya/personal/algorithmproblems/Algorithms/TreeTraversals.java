package com.aditya.personal.algorithmproblems.Algorithms;

import java.util.Stack;

public class TreeTraversals {

    static class BinaryNode<T> {

        private final T data;

        private BinaryNode<T> parent;

        private BinaryNode<T> left;

        private BinaryNode<T> right;

        public BinaryNode(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public BinaryNode<T> getParent() {
            return this.parent;
        }

        public BinaryNode<T> getLeft() {
            return this.left;
        }

        public BinaryNode<T> getRight() {
            return this.right;
        }
    }

    static class BinaryTree<T> {

        private BinaryNode<T> root;

        private int size = 0;

        public BinaryNode<T> getRoot() {
            return this.root;
        }

        public int getSize() {
            return this.size;
        }

        public void printPreOrder() {

            if (this.root == null)
                return;

            Stack<BinaryNode<T>> processStack = new Stack<>();

            processStack.push(this.root);

            while (!processStack.isEmpty()) {

                BinaryNode<T> current = processStack.pop();

                processNode(current);

                if (current.getRight() != null)
                    processStack.push(current.getRight());

                if (current.getLeft() != null)
                    processStack.push(current.getLeft());
            }
        }

        public void printInOrder() {

            if (this.root == null)
                return;

            Stack<BinaryNode<T>> processStack = new Stack<>();
            BinaryNode<T> current = this.root;

            while(current != null || !processStack.isEmpty()) {

                while (current != null) {
                    processStack.push(current);
                    current = current.getLeft();
                }

                current = processStack.pop();
                processNode(current);
                current = current.getRight();
            }
        }

        private void processNode(BinaryNode<T> node) {
            System.out.print(node.getData() + "-");
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bTree = new BinaryTree<>();

        bTree.root = new BinaryNode<>(10);
        bTree.root.left = new BinaryNode<>(7);
        bTree.root.right = new BinaryNode<>(11);

        bTree.root.left.left = new BinaryNode<>(6);
        bTree.root.left.right = new BinaryNode<>(8);

        bTree.root.left.left.left = new BinaryNode<>(1);
        bTree.root.left.right.right = new BinaryNode<>(9);


        bTree.root.right = new BinaryNode<>(11);
        bTree.root.right.right = new BinaryNode<>(20);
        bTree.root.right.right.left = new BinaryNode<>(14);
        bTree.root.right.right.right = new BinaryNode<>(22);

        bTree.printPreOrder();
        System.out.println();
        bTree.printInOrder();

    }
// 139 673 253
}
