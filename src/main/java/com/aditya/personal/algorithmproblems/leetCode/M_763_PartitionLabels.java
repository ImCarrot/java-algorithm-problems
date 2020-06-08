package com.aditya.personal.algorithmproblems.leetCode;

import java.util.*;

public class M_763_PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        Map<Character, Integer> charLastIndex = new HashMap<>();

        for (int i = 0; i < S.length(); i++)
            charLastIndex.put(S.charAt(i), i);

        List<Integer> partitions = new ArrayList<>();

        int startPoint = 0;

        for (int j = 0; j < S.length(); j++) {

            int currentEnd = charLastIndex.get(S.charAt(j));

            for (int i = startPoint; i <= currentEnd; i++) {

                if (charLastIndex.get(S.charAt(i)) > currentEnd)
                    currentEnd = charLastIndex.get(S.charAt(i));
            }

            partitions.add(S.substring(j, currentEnd + 1).length());

            j = currentEnd;
        }

        return partitions;
    }

    public List<Integer> partitionLabelsON(String S) {

        int[] lastIndexes = new int[26];

        for (int i = 0; i < S.length(); ++i)
            lastIndexes[S.charAt(i) - 'a'] = i;

        int currentMax = 0;
        int increment = 0;

        List<Integer> partitions = new ArrayList<>();

        for (int i = 0; i < S.length(); ++i) {
            currentMax = Math.max(currentMax, lastIndexes[S.charAt(i) - 'a']);
            if (i == currentMax) {
                partitions.add(i - increment + 1);
                increment = i + 1;
            }
        }
        return partitions;
    }

    public List<Integer> partitionLabelsOverKill(String S) {

        Map<Character, int[]> charIndexes = new LinkedHashMap<>();

        for (int i = 0; i < S.length(); i++) {

            if (!charIndexes.containsKey(S.charAt(i)))
                charIndexes.put(S.charAt(i), new int[]{i, i});

            else
                charIndexes.get(S.charAt(i))[1] = i;
        }

        PriorityQueue<Integer> partitions = new PriorityQueue<>(Comparator.reverseOrder());

        for (Map.Entry<Character, int[]> charIndex : charIndexes.entrySet()) {

            int[] indexes = charIndex.getValue();

            Integer currentMaxPartition = partitions.peek();

            if (currentMaxPartition != null && indexes[1] < currentMaxPartition)
                continue;

            for (int i = indexes[0]; i <= indexes[1]; i++) {

                char otherChar = S.charAt(i);

                int[] otherCharIndexes = charIndexes.get(otherChar);

                if (otherCharIndexes[1] > indexes[1])
                    indexes[1] = otherCharIndexes[1];
            }

            if (currentMaxPartition == null || indexes[1] > currentMaxPartition)
                partitions.add(indexes[1]);

            charIndexes.put(charIndex.getKey(), indexes);
        }

        Stack<Integer> subStrings = new Stack<>();

        while (!partitions.isEmpty())
            subStrings.push(partitions.poll());

        List<Integer> toReturn = new ArrayList<>();
        int start = 0;
        while (!subStrings.isEmpty()) {
            int endValue = subStrings.pop();
            toReturn.add(S.substring(start, endValue + 1).length());
            start = endValue + 1;
        }

        return toReturn;
    }

    public static void main(String[] args) {
        M_763_PartitionLabels instance = new M_763_PartitionLabels();
        System.out.println(instance.partitionLabelsON("ababcbacadefegdehijhklij")); // expected: [9,7,8]
    }

}
