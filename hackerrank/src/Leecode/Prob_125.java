package Leecode;

import utils.AssertUtils;

public class Prob_125 {
    public boolean isPalindrome(String s) {
        if(s.length() <= 0) return true;
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);
            while (left < right && !Character.isAlphabetic(leftCh) && !Character.isDigit(leftCh)) {
                left++;
                leftCh = s.charAt(left);
            }

            while (right > left && !Character.isAlphabetic(rightCh) && !Character.isDigit(rightCh)) {
                right --;
                rightCh = s.charAt(right);
            }
            if(left > right) break;
            if(Character.toLowerCase(leftCh) != Character.toLowerCase(rightCh)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Prob_125 prob = new Prob_125();

        AssertUtils.assertTrue(prob.isPalindrome(" "));
        AssertUtils.assertTrue(prob.isPalindrome("Aa"));
        AssertUtils.assertTrue(prob.isPalindrome("A,a"));
        AssertUtils.assertTrue(prob.isPalindrome("A,a,a"));
        AssertUtils.assertTrue(prob.isPalindrome("Aba"));
        AssertUtils.assertTrue(prob.isPalindrome("   A   b ,A"));
        AssertUtils.assertTrue(prob.isPalindrome("A man, a plan, a canal: Panama"));
        AssertUtils.assertFalse(prob.isPalindrome("race a car"));
    }
}
