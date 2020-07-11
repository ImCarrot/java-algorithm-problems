package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class M_207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        for (int[] edge : prerequisites)
            inDegree[edge[0]]++;

        Queue<Integer> zeroDegree = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0)
                zeroDegree.add(i);

        int cnt = 0;
        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        while (!zeroDegree.isEmpty()) {

            int course = zeroDegree.poll();

            for (int[] edge : prerequisites) {

                if (edge[1] == course && --inDegree[edge[0]] == 0)
                    zeroDegree.add(edge[0]);
            }
            topologicalOrder.add(course);
            cnt++;

        }

        // just because I wanted to do it
        System.out.println(topologicalOrder);

        return cnt == numCourses;
    }

    public static void main(String[] args) {

        M_207_CourseSchedule instance = new M_207_CourseSchedule();
        System.out.println(instance.canFinish(8, new int[][]{
                new int[]{1, 0},
                new int[]{2, 6},
                new int[]{1, 7},
                new int[]{6, 4},
                new int[]{7, 0},
                new int[]{0, 5},
        }));
    }
}
