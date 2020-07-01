package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FourSegmentsFormTriangle {

    private static boolean checkTriangle(int[][] coordinates) {

        if (coordinates.length != 4)
            return false;

        PriorityQueue<int[]> xSorted = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        xSorted.addAll(Arrays.asList(coordinates));

        int[] leftCandidate1 = xSorted.poll();
        int[] leftCandidate2 = xSorted.poll();

        int[] leftTop = null;
        int[] leftBottom = null;

        if (leftCandidate1[1] > leftCandidate2[0]) {
            leftTop = leftCandidate1;
            leftBottom = leftCandidate2;
        } else {
            leftTop = leftCandidate2;
            leftBottom = leftCandidate1;
        }

        int[] rightCandidate1 = xSorted.poll();
        int[] rightCandidate2 = xSorted.poll();

        int[] rightTop = null;
        int[] rightBottom = null;

        if (rightCandidate1[1] > rightCandidate2[0]) {
            rightTop = rightCandidate1;
            rightBottom = rightCandidate2;
        } else {
            rightTop = rightCandidate2;
            rightBottom = rightCandidate1;
        }

        double leftHeight = calculateDistance(leftTop, leftBottom);
        double rightHeight = calculateDistance(rightTop, rightBottom);

        if (leftHeight != rightHeight)
            return false;

        double topWidth = calculateDistance(leftTop, rightTop);
        double bottomWidth = calculateDistance(leftBottom, rightBottom);

        return topWidth == bottomWidth;
    }

    private static double calculateDistance(int[] pointA, int[] pointB) {

        if (pointA[1] == pointB[1])
            return Math.abs(pointB[0] - pointA[0]);

        if (pointA[0] == pointB[0])
            return Math.abs(pointB[1] - pointA[1]);

        // meaning use pythagoras

        int a = Math.abs(pointA[1] - pointB[1]);
        int b = Math.abs(pointA[0] - pointB[0]);

        return Math.sqrt((a*a) + (b*b));
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                new int[] {2, 4},
                new int[] {4, 2},
                new int[] {7, 5},
                new int[] {5, 7}};

        int[][] input2 = new int[][]{
                new int[] {7, 3},
                new int[] {10, 3},
                new int[] {10, 0},
                new int[] {7, 0}};


        System.out.println(checkTriangle(input2));
    }

}
