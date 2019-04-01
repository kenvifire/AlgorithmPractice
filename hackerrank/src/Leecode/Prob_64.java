package Leecode;

import utils.PrintUtils;

public class Prob_64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(i - 1 >= 0 ? dp[i-1][j] : Integer.MAX_VALUE,
                        j - 1 >= 0 ? dp[i][j-1] : Integer.MAX_VALUE) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Prob_64 prob = new Prob_64();
        System.out.println(prob.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
