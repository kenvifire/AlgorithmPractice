package Leecode;

import utils.AssertUtils;

public class Prob_680 {
    public boolean validPalindrome(String s) {
        if(s.length() <= 2) return true;

        int left = 0, right = s.length() - 1;

        while (left <= right && s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
        }

        if(left >= right) return true;

        int newLeft = left + 1;
        int newRight =  right;

        while (newLeft <= newRight) {
            if(s.charAt(newLeft) != s.charAt(newRight)) {
                break;
            }else {
                newLeft ++;
                newRight --;
            }
        }

        if (newLeft >= newRight) return true;

        newLeft = left;
        newRight =  right -1;

        while (newLeft <= newRight) {
            if(s.charAt(newLeft) != s.charAt(newRight)) {
                return false;
            }else {
                newLeft ++;
                newRight --;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        Prob_680 prob = new Prob_680();
        AssertUtils.assertTrue(prob.validPalindrome(""));
        AssertUtils.assertFalse(prob.validPalindrome("abc"));
        AssertUtils.assertTrue(prob.validPalindrome("aba"));
        AssertUtils.assertTrue(prob.validPalindrome("ab"));
        AssertUtils.assertTrue(prob.validPalindrome("aa"));


        AssertUtils.assertTrue(prob.validPalindrome("abcxcba"));
        AssertUtils.assertTrue(prob.validPalindrome("abxcba"));
        AssertUtils.assertTrue(prob.validPalindrome("abcxba"));
        AssertUtils.assertTrue(prob.validPalindrome("abca"));
        AssertUtils.assertTrue(prob.validPalindrome("abbax"));
        AssertUtils.assertTrue(prob.validPalindrome("ebcbbececabbacecbbcbe"));
    }
}
