package Leecode;

public class Prob_329 {
    int longest;
    int[][] directions = new int[][] {{-1,0}, {1,0} ,{0,1}, {0,-1}};
    int M, N;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        M = matrix.length;
        N = matrix[0].length;
        dp = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < M; i++) {
            for (int j = 0; j< N; j++) {
                findMax(matrix, i, j);
            }
        }

        int max = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(dp[i][j] > max)  {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    private int findMax(int[][] graph, int m, int n) {
        if(dp[m][n] != -1)  {
            return dp[m][n];
        }
        int val = graph[m][n];
        int max = 1;
        for(int[] direct : directions) {
            int x = m + direct[0];
            int y = n + direct[1];

            if(x >= 0 && x < M && y >= 0 && y < N ) {
                int nextVal = graph[x][y] ;
                if(nextVal < val)  {
                    int current = findMax(graph, x, y) + 1;
                    if(current > max) {
                        max = current;
                    }
                }
            }
        }
        dp[m][n] = max;
        return max;
    }
}
