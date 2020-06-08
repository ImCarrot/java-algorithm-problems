package com.aditya.personal.algorithmproblems.ctci.ArraysAndStrings;

public class StringCompression {

    public static String compress(String input) {

        if (input == null || input.trim().isEmpty())
            return input;

        input = input.toLowerCase();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            char character = input.charAt(i);

            int counter = 1;

            while (i + counter < input.length() && input.charAt(i + counter) == character) {
                counter += 1;
            }

            builder.append(character).append(counter);
            i += counter - 1;
        }

        String toReturn = builder.toString();
        return toReturn.length() > input.length() ? input : toReturn;

    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

}
