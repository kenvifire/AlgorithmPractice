package Leecode;

import utils.AssertUtils;

public class Prob_633 {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
           double j = Math.sqrt(c - i*i);
           if (j == (int)j) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Prob_633 prob = new Prob_633();
        AssertUtils.assertTrue(prob.judgeSquareSum(0));
        AssertUtils.assertTrue(prob.judgeSquareSum(1));
        AssertUtils.assertTrue(prob.judgeSquareSum(2));
        AssertUtils.assertFalse(prob.judgeSquareSum(3));
        AssertUtils.assertTrue(prob.judgeSquareSum(4));
        AssertUtils.assertTrue(prob.judgeSquareSum(5));
        AssertUtils.assertFalse(prob.judgeSquareSum(6));
    }
}
