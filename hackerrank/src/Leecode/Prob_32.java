package Leecode;

public class Prob_32 {
    int[][] dp;
    int N;
    public int longestValidParentheses(String s) {
        N = s.length();
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i==j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }


        return findMax(s, 0, s.length() - 1);
    }

    private int findMax(String s, int start, int end) {
        if(start >= N || end >= N) return 0;
        if(start >= end) return 0;
        char startCh = s.charAt(start);
        char endCh = s.charAt(end);

        if(dp[start][end] != -1) {
            return dp[start][end];
        } else if (end == start + 1) {
            if(startCh == '(' && endCh ==')') {
                dp[start][end] = 2;
                return 2;
            } else {
                dp[start][end] = 0;
                return 0;
            }

        } else {
            int max = 0;
            if(startCh =='(' && endCh == ')' && findMax(s, start + 1, end - 1) == (end - start + 1)) {
                max = end - start + 1;
                dp[end][start] = max;
                return max;
            } else {
                int left = findMax(s, start+1, end);
                int right = findMax(s, start, end + 1);
                max = Math.max(left, right);
                dp[end][start] = max;
                return max;
            }
        }

    }

    public static void main(String[] args) {
        Prob_32 prob = new Prob_32();
        System.out.println(prob.longestValidParentheses(")()())"));
    }
}
