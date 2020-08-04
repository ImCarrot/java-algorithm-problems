package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.Arrays;

public class MovieServiceProvider {

    public static int[] fetchTimings(int[] movies, int flightDuration) {

        if (movies.length < 2)
            return null;

        Arrays.sort(movies);

        int currentMax = Integer.MIN_VALUE;
        int[] pair = null;

        int j = movies.length - 1;
        int i = 0;

        while (i < j) {

            int sum = movies[i] + movies[j];

            if (sum > flightDuration) {
                j--;
                continue;
            }

            if (sum > currentMax) {
                currentMax = sum;
                pair = new int[] {movies[i], movies[j]};
            }

            i++;
        }
        return pair;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fetchTimings(new int[]{27, 1, 10, 39, 12, 52, 32, 67, 76}, 77)));
    }
}
