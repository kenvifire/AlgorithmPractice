package Leecode;

public class DivisorGama {
    public boolean divisorGame(int N) {
        boolean dp[] = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            boolean result = false;
            for(int j = 1; j <= i/2; j++) {
                if(i % j == 0) {
                    if(!dp[i - j]) {
                        result = true;
                        break;
                    }
                }
            }
            dp[i] = result;
        }
        return dp[N];

    }
}
