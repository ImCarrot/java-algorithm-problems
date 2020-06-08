package com.aditya.personal.algorithmproblems.leetCode;

import java.util.*;

public class M_133_CloneGraph {



// Definition for a Node.
private static class Node {
    public int val;

    public List<Node> neighbors;

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        if (node.neighbors.size() == 0)
            return new Node(node.val, node.neighbors);

        Map<Integer, Node> cloned = new HashMap<>();
        Queue<Node> processQueue = new LinkedList<>();

        processQueue.add(node);

        while (!processQueue.isEmpty()) {

            Node current = processQueue.poll();

            if (!cloned.containsKey(current.val))
                cloned.put(current.val, new Node(current.val));

            for (Node neighbor : current.neighbors) {

                if (!cloned.containsKey(neighbor.val)) {
                    processQueue.add(neighbor);
                    cloned.put(neighbor.val, new Node(neighbor.val));
                }

                cloned.get(current.val).neighbors.add(cloned.get(neighbor.val));
            }
        }

        // return any node since it's a connected undirected graph
        return cloned.values().stream().findFirst().orElse(null);
    }

}
