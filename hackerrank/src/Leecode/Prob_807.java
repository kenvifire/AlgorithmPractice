package Leecode;

import utils.AssertUtils;

public class Prob_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] topDown = new int[grid[0].length];
        int[] leftRight = new int[grid.length];

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
               if(grid[j][i] > max)  max = grid[j][i];
            }
            topDown[i] = max;
        }

        for (int i = 0; i < grid.length;i++ ){
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > max) max = grid[i][j];
            }

            leftRight[i] = max;
        }

        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
               int current = grid[i][j];
               int skyline = Math.min(topDown[j], leftRight[i]);

               if(current < skyline) total += skyline - current;
            }
        }
        return total;

    }

    public static void main(String[] args) {
        Prob_807 prob = new Prob_807();
        AssertUtils.equals(35, prob.maxIncreaseKeepingSkyline(new int[][] {
                {3,0,8,4},{2,4,5,7}, {9,2,6,3}, {0,3,1,0}
        }));

        AssertUtils.equals(0, prob.maxIncreaseKeepingSkyline(new int[][] {
                {0,0},{0,0}
        }));
    }
}
