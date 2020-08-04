package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;

public class E_70_ClimbingStairs {

    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {

        if (n < 0)
            return 0;

        if (n == 1 || n == 0)
            return 1;

        if (cache.containsKey(n))
            return cache.get(n);

        int ways = climbStairs(n-1) + climbStairs(n-2);

        cache.put(n, ways);
        return cache.get(n);
    }

}
