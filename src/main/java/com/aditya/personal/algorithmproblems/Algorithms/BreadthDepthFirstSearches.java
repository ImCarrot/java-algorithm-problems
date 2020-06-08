package com.aditya.personal.algorithmproblems.Algorithms;

import java.util.*;

public class BreadthDepthFirstSearches {

    static class Node<T> {

        private T data;

        private Node<T>[] relations;

        public Node(T item, Node<T>... relations) {
            this.data = item;

            this.relations = relations;
        }

        public T getData() {
            return this.data;
        }

        public Node<T>[] getRelations() {
            return this.relations;
        }
    }

    static class Graph<T> {

        private Node<T>[] nodes;

        public Graph(int nodeCount) {

            nodes = new Node[nodeCount];
        }

        public void addNode(Node<T> node) {

            int index = node.hashCode() % nodes.length;

            if (nodes[index] != null) {
                // TODO: handle collisions here.
            }

            nodes[index] = node;
        }

        public void printDFS(Node<T> node) {

            Stack<Node<T>> toProcess = new Stack<>();
            Set<T> visited = new HashSet<>();

            toProcess.push(node);

            while (!toProcess.isEmpty()) {

                Node<T> elementToProcess = toProcess.pop();
                if (!visited.contains(elementToProcess.getData())) {
                    visit(elementToProcess);
                    visited.add(elementToProcess.getData());
                }

                for (Node<T> relation : elementToProcess.getRelations()) {
                    if (!visited.contains(relation.getData())) {
                        toProcess.push(relation);
                    }
                }
            }
        }

        public void printBFS(Node<T> node) {

            Queue<Node<T>> toProcess = new LinkedList<>();
            Set<T> visited = new HashSet<>();

            toProcess.add(node);

            while (!toProcess.isEmpty()) {

                Node<T> elementToProcess = toProcess.poll();

                if (!visited.contains(elementToProcess.getData())) {

                    visit(elementToProcess);
                    visited.add(elementToProcess.getData());
                }

                for (Node<T> relation : elementToProcess.getRelations()) {

                    if (!visited.contains(relation.getData()))
                        toProcess.add(relation);
                }
            }
        }

        public boolean findPath(Node<T> start, Node<T> end) {

            Queue<Node<T>> processQueue = new LinkedList<>();
            Set<T> visited = new HashSet<>();
            processQueue.add(start);

            while (!processQueue.isEmpty()) {
                Node<T> current = processQueue.poll();
                if (!visited.contains(current.getData())) {
                    visited.add(current.getData());
                    if (current.getData() == end.getData())
                        return true;
                }

                for (Node<T> adj : current.getRelations()) {
                    if (!visited.contains(adj.getData()))
                        processQueue.add(adj);
                }
            }
            return false;
        }

        public void visit(Node<T> node) {
            System.out.print(node.getData());
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Node<Integer> zero = new Node<>(0, new Node<>(1), new Node<>(2));
        Node<Integer> three = new Node<>(3, new Node<>(3));
        Node<Integer> two = new Node<>(2, zero, three);
        Node<Integer> one = new Node<>(1, two);

        Graph<Integer> myGraph = new Graph<>(4);

        myGraph.addNode(zero);
        myGraph.addNode(one);
        myGraph.addNode(two);
        myGraph.addNode(three);

        myGraph.printDFS(two);
        System.out.println("\n---");
        myGraph.printBFS(two);
        System.out.println("\n---");
        System.out.println(myGraph.findPath(zero, three));
    }

}
