package Leecode;

import utils.AssertUtils;

public class Prob_96 {
    int[] dp;
    public int numTrees(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        nums(n);
        return dp[n];
    }
    private int nums(int n) {
        if(dp[n] != 0)  return dp[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums(n - 1 - i)  * nums(i);
        }
        dp[n] = sum;
        return sum;
    }


    public static void main(String[] args) {
        Prob_96 prob = new Prob_96();
        AssertUtils.equals(5, prob.numTrees(3));
    }


}
