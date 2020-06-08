package com.aditya.personal.algorithmproblems.ctci.ArraysAndStrings;

public class URLify {

    public static String urlify(String input) {

        if (input == null || input.trim().isEmpty())
            return "";

        char[] chars = input.toCharArray();
        char[] output = new char[chars.length];
        int increment = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] != ' ') {
                output[i + increment] = chars[i];
                continue;
            }

            if (i + increment == chars.length)
                break;

            output[i + increment] = '%';
            output[i + increment + 1] = '2';
            output[i + increment + 2] = '0';
            increment += 2;
        }

        return new String(output);
    }

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    "));
    }

}
