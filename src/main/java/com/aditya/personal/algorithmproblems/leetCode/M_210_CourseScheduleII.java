package com.aditya.personal.algorithmproblems.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class M_210_CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        for (int[] edge : prerequisites)
            inDegree[edge[0]]++;

        Queue<Integer> zeroDegree = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0)
                zeroDegree.add(i);

        int cnt = 0;

        int[] topologicalOrder = new int[numCourses];

        while (!zeroDegree.isEmpty()) {

            int course = zeroDegree.poll();

            for (int[] edge : prerequisites) {

                if (edge[1] == course && --inDegree[edge[0]] == 0)
                    zeroDegree.add(edge[0]);
            }
            topologicalOrder[cnt++] = course;
        }

        if (cnt != numCourses)
            return new int[0];

        return topologicalOrder;

    }

}
