package Leecode;

public class Prob1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];

        int max = 0;
        for(int i = 0; i < K; i++){
            if(A[i] > max) max = A[i];
            dp[i] = max * (i + 1);
        }

        for(int i = K; i < A.length; i++) {
            int localMax = 0;
            for(int j = 1; j <= K; j++) {
                int maxValue = 0;
                for(int n = i; n > i - j; n--){
                    if(A[n] > maxValue) {
                        maxValue = A[n];
                    }
                }

                int val = dp[i - j ] + maxValue * j;
                if(val > localMax) localMax = val;

            }
            dp[i] = localMax;

        }
        return dp[A.length - 1];

    }
}
