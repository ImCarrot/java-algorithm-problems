package com.aditya.personal.algorithmproblems.hackerrank.graphs;

import java.util.*;

public class M_RoadsAndLibraries {

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        if (c_road > c_lib)
            return c_lib * n;

        int[] connectedComponents = buildCC(n, cities);

        Map<Integer, Long> counts = new HashMap<>();

        for (int i = 1; i < connectedComponents.length; i++)
            counts.put(connectedComponents[i], counts.getOrDefault(connectedComponents[i], 0L) + 1);

        long numberOfDisconnected = counts.getOrDefault(-1, 0L);

        counts.remove(-1); // remove all disconnected

        long cost = counts.size() * c_lib;

        for (int component : counts.keySet()) {
            cost += c_road * (counts.get(component) - 1);
        }

        cost += numberOfDisconnected * c_lib;
        System.out.println(cost);
        return cost;
    }

    private static int[] buildCC(int noOfCities, int[][] cityRoads) {

        int[] connected = new int[noOfCities + 1];
        Arrays.fill(connected, -1);

        for (int[] roads: cityRoads) {
            if (connected[roads[0]] == -1 && connected[roads[1]] == -1) {
                connected[roads[0]] = roads[0];
                connected[roads[1]] = roads[0];

            } else if (connected[roads[0]] == -1 && connected[roads[1]] != -1)
                connected[roads[0]] = connected[roads[1]];

            else if (connected[roads[0]] != -1 && connected[roads[1]] == -1)
                connected[roads[1]] = connected[roads[0]];
        }
        return connected;
    }

    public static void main(String[] args) {

//        int[][] graph = new int[][]{
//                new int[]{1, 3},
//                new int[]{3, 4},
//                new int[]{2, 4},
//                new int[]{1, 2},
//                new int[]{2, 3},
//                new int[]{5, 6},
//        };

        int[][] graph = new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 4}
        };


        System.out.println(roadsAndLibraries(5, 6, 1, graph));
    }

}
