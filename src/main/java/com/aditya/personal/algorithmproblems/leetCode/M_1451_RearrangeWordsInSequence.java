package com.aditya.personal.algorithmproblems.leetCode;

public class M_1451_RearrangeWordsInSequence {

    public String arrangeWords(String text) {

        text = text.toLowerCase();

        String[] words = text.split("\\s+");

        String[] sortedWords = mergeSort(words);

        boolean isFirst = true;

        StringBuilder outputBuilder = new StringBuilder();
        for (String word : sortedWords) {

            if (isFirst) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
                isFirst = false;
            }
            outputBuilder.append(word);
            outputBuilder.append(' ');
        }

        return outputBuilder.toString().trim();
    }

    private String[] mergeSort(String[] words) {

        if (words.length < 2)
            return words;

        int mid = words.length / 2;

        String[] left = new String[mid];

        System.arraycopy(words, 0, left, 0, mid);

        String[] right = new String[words.length - mid];
        int inc = 0;
        for (int i = mid; i < words.length; i++) {
            right[inc] = words[i];
            inc++;
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return mergeTwoSorted(left, right);
    }

    private String[] mergeTwoSorted(String[] left, String[] right) {
        String[] toReturn = new String[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].length() <= right[j].length()) {
                toReturn[k] = left[i];
                i++;
                k++;
            } else {
                toReturn[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length) {
            toReturn[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            toReturn[k] = right[j];
            j++;
            k++;
        }

        return toReturn;
    }


    public static void main(String[] args) {
        M_1451_RearrangeWordsInSequence instance = new M_1451_RearrangeWordsInSequence();

        System.out.println(instance.arrangeWords("Leetcode is cool")); // Is cool leetcode
        System.out.println(instance.arrangeWords("Keep calm and code on")); // expected: On and keep calm code
        System.out.println(instance.arrangeWords("To be or not to be")); // expected: To be or to be not
    }
}
