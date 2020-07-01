package com.aditya.personal.algorithmproblems.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E_1431_KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandies = Integer.MIN_VALUE;
        for (int candy : candies)
            maxCandies = Math.max(candy, maxCandies);

        List<Boolean> toReturn = new ArrayList<>();

        for (int candy : candies)
            toReturn.add(candy + extraCandies >= maxCandies);

        return toReturn;
    }

}
