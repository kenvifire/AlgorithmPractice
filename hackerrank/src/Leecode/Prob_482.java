package Leecode;

import utils.AssertUtils;

public class Prob_482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length();i++) {
            if(S.charAt(i) != '-') sb.append(S.charAt(i));
        }

        int currentSeg = sb.length() % K;
        if(currentSeg == 0) {
            currentSeg = K;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {

            if(i == currentSeg) {
                result.append('-');
                currentSeg += K ;
            }
            result.append(Character.toUpperCase(sb.charAt(i)));

        }
        return result.toString();

    }

    public static void main(String[] args) {
        Prob_482 prob = new Prob_482();
        AssertUtils.equals("5F3Z-2E9W", prob.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        AssertUtils.equals("2-5G-3J", prob.licenseKeyFormatting("2-5g-3-J", 2));
        AssertUtils.equals("A-A-A-A", prob.licenseKeyFormatting("a-a-a-a-", 1));
        AssertUtils.equals("AA-AA", prob.licenseKeyFormatting("--a-a-a-a--", 2));
    }
}
