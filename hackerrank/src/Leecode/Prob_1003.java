package Leecode;

import utils.AssertUtils;

import java.util.HashMap;
import java.util.Map;

public class Prob_1003 {
    public boolean isValid(String S) {
        if(S.length() == 0) return false;
        if (S.length() % 3 != 0) return false;

        int[] cntMap = new int[3];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int index = ch - 'a';
            if(index > 3) return false;

            cntMap[index] += 1;

            if(cntMap[0] < cntMap[1] || cntMap[0] < cntMap[2] || cntMap[1] < cntMap[2]) return false;

        }

        return cntMap[0] == cntMap[1] && cntMap[1] == cntMap[2];


    }

    public static void main(String[] args) {
        Prob_1003 prob = new Prob_1003();
        AssertUtils.assertTrue(prob.isValid("aabcbc"));
        AssertUtils.assertTrue(prob.isValid("abc"));
        AssertUtils.assertTrue(prob.isValid("aabcbc"));
        AssertUtils.assertTrue(prob.isValid("abcabc"));
        AssertUtils.assertTrue(prob.isValid("abcabcababcc"));
        AssertUtils.assertFalse(prob.isValid("abccba"));
        AssertUtils.assertFalse(prob.isValid("cababc"));
        AssertUtils.assertFalse(prob.isValid("cba"));
        AssertUtils.assertTrue(prob.isValid("aabcbcabc"));
        AssertUtils.assertTrue(prob.isValid("aabcbabcc"));
        AssertUtils.assertFalse(prob.isValid("aaa"));
    }
}
