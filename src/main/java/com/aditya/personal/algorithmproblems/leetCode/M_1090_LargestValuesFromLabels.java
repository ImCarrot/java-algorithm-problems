package com.aditya.personal.algorithmproblems.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class M_1090_LargestValuesFromLabels {

    public static class Item {
        int value;

        int label;

        public Item(int val, int lab) {
            this.value = val;
            this.label = lab;
        }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        PriorityQueue<Item> maxValues = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));

        for (int i = 0; i < values.length; i++)
            maxValues.add(new Item(values[i], labels[i]));

        Map<Integer, Integer> labelsUsed = new HashMap<>();

        int sum = 0;

        while (num_wanted > 0 && !maxValues.isEmpty()) {

            while (!maxValues.isEmpty() && labelsUsed.getOrDefault(maxValues.peek().label, 0) >= use_limit)
                maxValues.poll();

            Item current = maxValues.poll();

            if (current == null)
                break;

            sum += current.value;
            labelsUsed.put(current.label, labelsUsed.getOrDefault(current.label, 0) + 1);
            num_wanted--;
        }

        return sum;
    }

    public static void main(String[] args) {

        M_1090_LargestValuesFromLabels instance = new M_1090_LargestValuesFromLabels();
//        System.out.println(instance.largestValsFromLabels(new int[]{3, 2, 3, 2, 1},
//                new int[]{1, 0, 2, 2, 1}, 2, 1));
/*
[]
[]
3
1
 */
//        System.out.println(instance.largestValsFromLabels(new int[]{9, 8, 8, 7, 6},
//                new int[]{0, 0, 0, 1, 1}, 3, 2));

        System.out.println(instance.largestValsFromLabels(new int[]{9, 8, 8, 7, 6},
                new int[]{0, 0, 0, 1, 1}, 3, 1));
    }

}
