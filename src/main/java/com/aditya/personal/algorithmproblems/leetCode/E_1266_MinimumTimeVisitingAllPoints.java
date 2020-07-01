package com.aditya.personal.algorithmproblems.leetCode;

public class E_1266_MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {

        int moves = 0;

        for (int i = 0; i < points.length - 1; i++) {

            int currentX = points[i][0];
            int currentY = points[i][1];
            int destinationX = points[i + 1][0];
            int destinationY = points[i + 1][1];

            while (currentX != destinationX || currentY != destinationY) {

                if (currentX < destinationX)
                    currentX += 1;
                else if (currentX > destinationX)
                    currentX -= 1;

                if (currentY < destinationY)
                    currentY += 1;
                else if (currentY > destinationY)
                    currentY -= 1;

                moves += 1;
            }
        }
        return moves;
    }

}
