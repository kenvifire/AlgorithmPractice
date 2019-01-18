package Leecode;

import utils.AssertUtils;

public class Prob_5_v1 {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String maxString = "";
        for (int i = 0; i < s.length() ; i++) {
           for (int j = i ; j< s.length(); j++) {
                if(isPalindrom(s.substring(i, j + 1)) && (j-i + 1) > maxLen) {
                   maxLen = j-i + 1;
                   maxString = s.substring(i, j + 1);
                }
           }
        }
        return maxString;
    }

    private boolean isPalindrom(String s) {
        int len = s.length();
        if(len == 0 || len == 1) return true;
        if(s.charAt(0) == s.charAt(len - 1 )) {
            return isPalindrom(s.substring(1, len-1));
        }

        return false;
    }


    public static void main(String[] args) {
        Prob_5_v1 prob_5V1 = new Prob_5_v1();
        AssertUtils.equals("a", prob_5V1.longestPalindrome("a") );
        AssertUtils.equals("a", prob_5V1.longestPalindrome("abcd") );
        AssertUtils.equals("", prob_5V1.longestPalindrome("") );
        AssertUtils.equals("bab", prob_5V1.longestPalindrome("babad") );
        AssertUtils.equals("bb", prob_5V1.longestPalindrome("cbbd") );
        AssertUtils.equals("bb", prob_5V1.longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa") );
    }
}
