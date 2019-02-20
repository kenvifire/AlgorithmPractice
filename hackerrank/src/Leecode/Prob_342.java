package Leecode;

import utils.AssertUtils;

public class Prob_342 {
    public boolean isPowerOfFour(int n) {
        if(n==1) return true;
        if (n <= 3) return false;


        long base = 4;
        while (n >= base) {
            if(n % base == 0 && n / base == 1) {
                return true;
            }
            base *= 4;
        }
        return false;
    }

    public static void main(String[] args) {
        Prob_342 prob = new Prob_342();
        AssertUtils.assertFalse(prob.isPowerOfFour(3));
        AssertUtils.assertFalse(prob.isPowerOfFour(5));
        AssertUtils.assertFalse(prob.isPowerOfFour(6));
        AssertUtils.assertFalse(prob.isPowerOfFour(7));
        AssertUtils.assertFalse(prob.isPowerOfFour(8));
        AssertUtils.assertFalse(prob.isPowerOfFour(9));
        AssertUtils.assertFalse(prob.isPowerOfFour(10));
        AssertUtils.assertFalse(prob.isPowerOfFour(11));
        AssertUtils.assertFalse(prob.isPowerOfFour(12));
        AssertUtils.assertFalse(prob.isPowerOfFour(13));
        AssertUtils.assertTrue(prob.isPowerOfFour(16));
        AssertUtils.assertFalse(prob.isPowerOfFour(1162261466));
    }
}
