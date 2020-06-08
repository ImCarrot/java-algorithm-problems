package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class M_973_KClosestPointsToOrigin {

    private static class DistanceResult implements Comparable<DistanceResult> {

        private final int[] point;

        private final Double distance;

        private DistanceResult(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public int compareTo(DistanceResult o) {
            return this.distance.compareTo(o.distance);
        }
    }

    public static int[][] kClosest(int[][] points, int K) {


        PriorityQueue<DistanceResult> result = new PriorityQueue<>(DistanceResult::compareTo);

        for (int[] point : points) {
            result.add(getDistance(point));
        }

        int[][] returner = new int[K][2];

        while (K != 0 && !result.isEmpty()) {
            returner[K - 1] = result.poll().point;
            K--;
        }

        return returner;
    }


    private static DistanceResult getDistance(int[] point) {

        int xDistance = Math.abs(point[0]);
        int yDistance = Math.abs(point[1]);

        double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
        return new DistanceResult(point, distance);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {-2, 2}};
        int[][] output = kClosest(input, 1);
        System.out.println(Arrays.deepToString(output));
    }

}
