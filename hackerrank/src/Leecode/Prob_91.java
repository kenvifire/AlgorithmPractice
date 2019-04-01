package Leecode;

import utils.AssertUtils;

public class Prob_91 {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;

        if(validSingle(s.charAt(0))) {
            dp[1] = 1;
        }
        if(s.length() > 1)  {
            dp[2] = (validSingle(s.charAt(0)) && validSingle(s.charAt(1)) ? 1 : 0) + (validDouble(s, 0) ? 1 : 0);
        }

        for (int i = 2; i < s.length(); i++) {
            if(validSingle(s.charAt(i))) {
                dp[i+1] += dp[i];
            }
            if (validDouble(s, i - 1)) {
                dp[i + 1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }

//    private void decode(String s, int pos) {
//        if(pos == s.length()) {
//            cnt ++;
//            return;
//        }
//
//        if(pos == s.length() - 1) {
//            if(validSingle(s.charAt(pos))) {
//                cnt++;
//            }
//            return;
//        } else {
//            if(validSingle(s.charAt(pos))) {
//                decode(s, pos + 1);
//            }
//
//            if(validDouble(s, pos)) {
//                decode(s, pos + 2);
//            }
//        }

//    }
    private boolean validSingle(char ch) {
        return ch > '0' && ch <= '9';
    }

    private boolean validDouble(String str, int pos) {
        String sub = str.substring(pos, pos + 2);
        return sub.compareTo("10") >=0 && sub.compareTo("26") <=0;
    }

    public static void main(String[] args) {
        Prob_91 prob = new Prob_91();
        AssertUtils.equals(2,prob.numDecodings("12"));
        AssertUtils.equals(3,prob.numDecodings("226"));
        AssertUtils.equals(0,prob.numDecodings(""));
        AssertUtils.equals(1,prob.numDecodings("99"));
        AssertUtils.equals(1,prob.numDecodings("999"));
        AssertUtils.equals(1,prob.numDecodings("36"));
        AssertUtils.equals(4,prob.numDecodings("2626"));
        AssertUtils.equals(0,prob.numDecodings("0"));
        AssertUtils.equals(1,prob.numDecodings("110"));
    }
}
