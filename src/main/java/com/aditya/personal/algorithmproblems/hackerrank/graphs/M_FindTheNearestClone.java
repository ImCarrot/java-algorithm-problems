package com.aditya.personal.algorithmproblems.hackerrank.graphs;

import java.util.*;

public class M_FindTheNearestClone {

    public static class Node {
        private int value;
        private long colour;
        private List<Node> adj;

        public Node(int value, long colour) {
            this.value = value;
            this.colour = colour;
            this.adj = new ArrayList<>();
        }
    }

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {

        Map<Integer, Node> graph = generateGraphAndFind(graphFrom, graphTo, ids);

        List<Node> startPoints = new ArrayList<>();
        for (Map.Entry<Integer, Node> node: graph.entrySet()) {
            if (node.getValue().colour == val)
                startPoints.add(node.getValue());
        }

        if (startPoints.size() < 2)
            return -1;

        int minDistance = Integer.MAX_VALUE;

        for (Node startPoint: startPoints) {
            int distance = calculateDist(startPoint, val, graphNodes);
            minDistance = Math.min(minDistance, distance);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private static int calculateDist(Node startPoint, int val, int nodeCount) {
        Stack<Node> toProcess = new Stack<>();
        Queue<Integer> visited = new LinkedList<>();
        visited.add(startPoint.value);

        int[] parents = new int[nodeCount + 1];
        Arrays.fill(parents, -1);

        for (Node child: startPoint.adj) {
            toProcess.push(child);
            parents[child.value] = startPoint.value;
        }

        Node current = null;
        boolean found = false;
        while (!toProcess.isEmpty()) {

            current = toProcess.pop();

            if (!visited.contains(current.value)) {
                visited.add(current.value);
                if (current.colour == val){
                    found = true;
                    break;
                }

            }

            for (Node child: current.adj) {
                if (!visited.contains(child.value)) {
                    toProcess.push(child);
                    parents[child.value] = current.value;
                }
            }
        }

        if (!found)
            return Integer.MAX_VALUE;

        int steps = 0;
        int value = current.value;
        while (parents[value] != -1) {
            steps++;
            value = parents[value];
        }
        return steps;
    }

    private static Map<Integer, Node> generateGraphAndFind(int[] graphFrom, int[] graphTo, long[] colours) {

        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < graphFrom.length; i++) {

            int from = graphFrom[i];
            int to = graphTo[i];

            if (!graph.containsKey(from))
                graph.put(from, new Node(from, colours[from - 1]));

            if (!graph.containsKey(to))
                graph.put(to, new Node(to, colours[to - 1]));

            graph.get(from).adj.add(graph.get(to));
            graph.get(to).adj.add(graph.get(from));
        }

        return graph;
    }

    public static void main(String[] args) {
        System.out.println(findShortest(5, new int[]{1, 1, 2, 3}, new int[]{2, 3, 4, 5}, new long[]{1, 2, 3, 3, 2}, 2));
    }

}
