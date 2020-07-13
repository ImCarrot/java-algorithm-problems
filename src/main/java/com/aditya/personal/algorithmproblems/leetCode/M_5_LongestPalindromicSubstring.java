package com.aditya.personal.algorithmproblems.leetCode;

public class M_5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLengthCase = fetchPalindromeLength(s, i, i);
            int evenLengthCase = fetchPalindromeLength(s, i, i + 1);

            int maxLength = Math.max(oddLengthCase, evenLengthCase);

            if (maxLength > end - start) {
                start = i - ((maxLength - 1) / 2);
                end = i + (maxLength / 2);
            }

        }
        return s.substring(start, end + 1);
    }

    private int fetchPalindromeLength(String s, int left, int right) {

        if (left > right || s == null || s.trim().isEmpty())
            return 0;


        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        M_5_LongestPalindromicSubstring instance = new M_5_LongestPalindromicSubstring();
        System.out.println(instance.longestPalindrome("aabbaa"));
    }

}
