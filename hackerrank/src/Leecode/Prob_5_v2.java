package Leecode;

import utils.AssertUtils;

public class Prob_5_v2 {
    public String longestPalindrome(final String s) {
        if (s == null || s.length() == 0 ) return "";
        return longestCommonSubString(s, reverseString(s));
    }


    public String longestCommonSubString(final String s1, final String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // init
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = 0;
        }

        int palinIndex = 0;
        int palinMax = 0;
        //dp
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j ++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > palinMax) {
                        int len = dp[i + 1][j + 1];

                        // s1 --> [left offset][target string][right offset]
                        // s2 --> [s1.right offset][s1.target string][s1.left offset]
                        // s1.left offset == s2.right offset && s1.right offset == s2.left offset
                        int s1Left = i + 1 - len;
                        int s1Right = s1.length() - 1 - i;
                        int s2Left = j + 1 - len;
                        int s2Right = s2.length()- 1 - j;
                        if (s1Left == s2Right && s1Right == s2Left) {
                            palinIndex = i;
                            palinMax = len;
                        }
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        //find max

        return s1.substring(palinIndex - palinMax + 1, palinIndex + 1);

    }

    public String reverseString(final String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }




    public static void main(String[] args) {
        Prob_5_v2 prob_5v2 = new Prob_5_v2();
//        Assert.equals("a", prob_5v2.longestPalindrome("a") );
//        Assert.equals("a", prob_5v2.longestPalindrome("abcd") );
//        Assert.equals("", prob_5v2.longestPalindrome("") );
        AssertUtils.equals("bab", prob_5v2.longestPalindrome("babad") );
//        Assert.equals("bb", prob_5v2.longestPalindrome("cbbd") );
//        Assert.equals("bb", prob_5v2.longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa") );
    }
}
