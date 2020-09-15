package Leecode.contest202;

public class Prob5490 {
    public int minDays(int n) {
        int dp[] = new int[n+1];
        dp[n] = 0;

        for(int i = n-1; i <= 3*n; i-- ) {
            if(i <= n) dp[i] = dp[i+1] + 1;
            if(i * 2 <= n) dp[i] = Math.min(dp[2*i] + 1, dp[i]);
            if(i % 2 == 0 && (3*i)/2 <= n) dp[i] = Math.min(dp[i], dp[(3*i)/2] + 1);
        }

        return dp[0];


    }

    public static void main(String[] args) {
        Prob5490 prob = new Prob5490();
        prob.minDays(6);
    }


}
