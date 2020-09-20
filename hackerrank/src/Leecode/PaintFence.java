package Leecode;

/**
 * https://leetcode.com/problems/paint-fence/
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0 ) return 0;
        if(n == 1) return k;
        int[][] dp = new int[n][2];
        dp[0][0] = k;
        dp[0][1] = 0;
        dp[1][0] = k;
        dp[1][1] = k * (k-1);

        for(int i = 2; i < n; i++ ) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] * (k-1) + dp[i-1][1] * (k - 1);
        }

        return dp[n-1][0] + dp[n-1][1];

    }
}
