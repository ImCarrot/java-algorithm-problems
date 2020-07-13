package com.aditya.personal.algorithmproblems.leetCode;

public class H_214_ShortestPalindrome {

    public String shortestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = s.length() - 1; i > 0; i--) {

            boolean palin = isPalindrome(s, i);

            if (palin) {
                end = i;
                break;
            }
        }

        StringBuilder outputBuilder = new StringBuilder();

        for (int i = end + 1; i < s.length(); i++)
            outputBuilder.insert(0, s.charAt(i));

        for (int i = start; i <= end; i++)
            outputBuilder.append(s.charAt(i));

        for (int i = end + 1; i < s.length(); i++)
            outputBuilder.append(s.charAt(i));

        return outputBuilder.toString();

    }

    private boolean isPalindrome(String s, int right) {

        int left = 0;

        if (left > right || s == null || s.trim().isEmpty())
            return false;


        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1 > 0;
    }

    public static void main(String[] args) {
        H_214_ShortestPalindrome instance = new H_214_ShortestPalindrome();
        System.out.println(instance.shortestPalindrome("abcd"));
    }

}
