package com.aditya.personal.algorithmproblems.leetCode;

public class E_482_LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {

        String S1 = S.replace("-","").toUpperCase();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < S1.length(); i++)
            sb.append(S1.charAt(i));

        for(int i = K; i < S1.length(); i += K)
            sb.insert(S1.length() - i,'-');

        return sb.toString();
    }

    public static void main(String[] args) {
        E_482_LicenseKeyFormatting instance = new E_482_LicenseKeyFormatting();
        System.out.println(instance.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(instance.licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(instance.licenseKeyFormatting("2-4A0r7-4k", 3));
    }

}
