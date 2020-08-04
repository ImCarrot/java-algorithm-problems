package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.*;

public class WordLadder {

    public static int shortestChain(String start, String end, String[] dictionary) {

        if (start == null || end == null || dictionary.length == 0)
            return -1;

        Map<String, Set<String>> graph = new HashMap<>();

        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < dictionary.length; j++) {

                if (i == j)
                    continue;

                if (!graph.containsKey(dictionary[i]))
                    graph.put(dictionary[i], new HashSet<>());

                if (isDistanceOne(dictionary[i], dictionary[j]))
                    graph.get(dictionary[i]).add(dictionary[j]);

            }
        }

        Queue<String> toProcess = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        toProcess.add(start);
        int level = 0;
        while (!toProcess.isEmpty()) {
            level++;
            int size = toProcess.size();

            while (size > 0) {

                String current = toProcess.poll();

                if (visited.contains(current))
                    continue;

                visited.add(current);

                if (current.equals(end))
                    break;

                for (String oneStep : graph.get(current)) {
                    if (!visited.contains(oneStep))
                        toProcess.add(oneStep);
                }

                size--;
            }
        }

        return level;
    }

    private static boolean isDistanceOne(String from, String to) {

        boolean canFail = true;

        int pointer = 0;
        while (pointer != from.length()) {

            if (from.charAt(pointer) == to.charAt(pointer)) {
                pointer++;
                continue;
            }

            if (canFail)
                canFail = false;
            else
                break;
            pointer++;
        }

        return pointer == from.length();
    }

    public static void main(String[] args) {
        System.out.println(shortestChain("TOON", "PLEA", new String[]{"POON", "PLEE", "SAME", "POIE",
                "PLEA", "PLIE", "POIN", "TOON"}));
    }
}
