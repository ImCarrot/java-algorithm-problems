package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

    public boolean topologicalSort(int[][] dependencies, int totalCount) {

        int[] inDegree = new int[totalCount + 1];

        for (int[] dependency : dependencies)
            inDegree[dependency[0]] += 1;

        Queue<Integer> toProcess = new LinkedList<>();

        for (int i = 0; i < totalCount; i++) {
            if (inDegree[i] == 0)
                toProcess.add(i);

        }

        int processed = 0;
        while (!toProcess.isEmpty()) {

            int value = toProcess.poll();

            for (int[] dependency : dependencies) {

                if (dependency[1] == value) {
                    inDegree[dependency[0]]--;

                    if (inDegree[dependency[0]] == 0) {
                        toProcess.add(dependency[0]);
                    }
                }
            }
            processed++;
        }

        return processed == totalCount;
    }

}
