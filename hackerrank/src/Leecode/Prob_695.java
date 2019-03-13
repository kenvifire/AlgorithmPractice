package Leecode;

import utils.AssertUtils;

public class Prob_695 {
    int max;
    int size;
    boolean[][] visited;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        max = Integer.MIN_VALUE;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                size = 0;
                if(!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
                if (size > max) { max = size; }
            }
        }

        return max;
    }

    private void dfs(int[][] grid, int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;
        size++;

        for (int[] direct : directions) {
            int xHat = x + direct[0];
            int yHat = y + direct[1];
            if(xHat >= 0 && xHat < grid.length && yHat >=0 && yHat < grid[0].length && grid[xHat][yHat] == 1) {
                dfs(grid, xHat, yHat);
            }
        }

    }

    public static void main(String[] args) {
        Prob_695 prob = new Prob_695();
        AssertUtils.equals(6, prob.maxAreaOfIsland(new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));

        AssertUtils.equals(1, prob.maxAreaOfIsland(new int[][]{{1}}));
        AssertUtils.equals(2, prob.maxAreaOfIsland(new int[][]{{1,1, 0, 1}}));
    }


}
