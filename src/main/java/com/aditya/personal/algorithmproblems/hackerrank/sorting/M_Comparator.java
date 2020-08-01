package com.aditya.personal.algorithmproblems.hackerrank.sorting;

import java.util.Comparator;

public class M_Comparator {

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player> {

        // complete this method
        public int compare(Player a, Player b) {

            if (a.score > b.score)
                return -1;
            else if (b.score > a.score)
                return 1;
            else
                return a.name.compareTo(b.name);
        }
    }

}
