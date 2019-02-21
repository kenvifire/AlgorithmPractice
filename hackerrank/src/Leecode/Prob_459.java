package Leecode;

import utils.AssertUtils;

public class Prob_459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();

        for (int segLen = 1; segLen <= s.length() / 2; segLen ++) {
            if(len % segLen != 0) continue;

            String subStr = s.substring(0, segLen);

            boolean isRepeated = true;
            for (int i = segLen; i < s.length(); i += segLen) {
                if (!s.startsWith(subStr, i)) {
                    isRepeated = false;
                    break;
                }
            }
            if(isRepeated) return true;

        }

        return false;
    }

    public static void main(String[] args) {
        Prob_459 prob = new Prob_459();

        AssertUtils.assertFalse(prob.repeatedSubstringPattern("a"));
        AssertUtils.assertFalse(prob.repeatedSubstringPattern("ab"));
        AssertUtils.assertFalse(prob.repeatedSubstringPattern("abc"));
        AssertUtils.assertFalse(prob.repeatedSubstringPattern("ababc"));
        AssertUtils.assertFalse(prob.repeatedSubstringPattern("abcab"));
        AssertUtils.assertTrue(prob.repeatedSubstringPattern("aa"));
        AssertUtils.assertTrue(prob.repeatedSubstringPattern("abab"));
        AssertUtils.assertTrue(prob.repeatedSubstringPattern("abab"));
        AssertUtils.assertTrue(prob.repeatedSubstringPattern("abcabcabcabc"));
    }
}
