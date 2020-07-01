package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;

public class E_914_XOfKindInDeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (int num: deck)
            counts.put(num, counts.getOrDefault(num, 0) + 1);

        int result = -1;

        for (Map.Entry<Integer, Integer> occ : counts.entrySet()) {
            if (occ.getValue() < 2)
                return false;

            if (result == -1)
                result = occ.getValue();

            else
                result = gcd(result, occ.getValue());
        }

        return result >= 2;
    }

    private int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
