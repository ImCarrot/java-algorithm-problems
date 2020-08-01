package com.aditya.personal.algorithmproblems.geeksForGeeks;

import java.util.*;

public class RandomSet {

    Map<Integer, Integer> valIndexes = new HashMap<>();

    List<Integer> values = new ArrayList<>();

    public void insert(int x) {
        if (valIndexes.containsKey(x))
            return;

        valIndexes.put(x, values.size());
        values.add(x);
    }

    public void remove(int x) {

        if (!valIndexes.containsKey(x))
            throw new IllegalArgumentException("The number doesn't exist.");

        int index = valIndexes.get(x);

        int lastElement = values.get(values.size() - 1);

        // swap the last element with the current element so that all the ops happen in O()1
        Collections.swap(values, index, values.size() - 1);
        valIndexes.put(lastElement, index);

        valIndexes.remove(values.size() - 1);
    }

    public boolean search(int x) {
        return valIndexes.containsKey(x);
    }

    public int getRandom() {

        Random random = new Random();
        int number = random.nextInt(100000);

        int index = number % values.size();
        return values.get(index);
    }

}
