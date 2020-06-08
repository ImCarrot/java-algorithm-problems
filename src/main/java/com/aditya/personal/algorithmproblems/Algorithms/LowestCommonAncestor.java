package com.aditya.personal.algorithmproblems.Algorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestor {

    public static class Node {

        String name;
        Node[] reportees;
    }

    public static Node findLCA(Node boss, Node emp1, Node emp2) {

        if (boss == null || boss.reportees.length == 0)
            return null;

        Node[] emp1Parents = lookupParentsDFS(boss, emp1);
        Node[] emp2Parents = lookupParentsDFS(boss, emp2);

        int minLength = Math.min(emp1Parents.length, emp2Parents.length);

        int matchIndex = 0;
        for (int i = 0; i < minLength; i++) {
            if (emp1Parents[i].equals(emp2Parents[i]))
                matchIndex++;
            else
                break;
        }

        return emp1Parents[matchIndex];
    }

    public static Node[] lookupParentsDFS(Node node, Node employee) {

        if (node == null)
            return null;

        Stack<Node> processStack = new Stack<>();
        Set<String> visited = new HashSet<>();

        processStack.push(node);

        while (!processStack.empty()) {

            Node current = processStack.pop();

            if (!visited.contains(current.name)) {
                visited.add(current.name);
                if (current.name.equals(employee.name))
                    break;
            }

            for (Node reportee : current.reportees) {
                if (!visited.contains(reportee.name))
                    processStack.push(reportee);
            }
        }

        Node[] parents = new Node[processStack.size()];

        while (!processStack.empty()) {
            int index = processStack.size() - 1;
            parents[index] = processStack.pop();
        }

        return parents;
    }
}
