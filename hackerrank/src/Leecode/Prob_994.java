package Leecode;

import utils.AssertUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob_994 {

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int maxCnt = -1;
    private int[][] directions = new int[][] {{0, -1}, {0,1}, {1,0}, {-1,0}};
    private int freshCnt = 0;
    public int orangesRotting(int[][] grid) {

        Queue<Point> pointQueue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    pointQueue.offer(new Point(i, j));
                } else if(grid[i][j] == 1) {
                    freshCnt ++;
                }
            }
        }



        if(freshCnt == 0) return 0;
        boolean[][] flags = new boolean[grid.length][grid[0].length];

        int height = 0;
        while (!pointQueue.isEmpty()) {
            int n = pointQueue.size();
            height++;

            for (int i = 0; i < n; i ++) {
                Point current = pointQueue.poll();
                if(flags[current.x][current.y]) continue;


                flags[current.x][current.y] = true;

                for (int[] direct : directions) {
                    int xHat = current.x + direct[0];
                    int yHat = current.y + direct[1];

                    if(xHat >= 0 && xHat < grid.length && yHat >= 0 && yHat < grid[0].length && grid[xHat][yHat] != 0) {
                        if(grid[xHat][yHat] == 1) {
                            grid[xHat][yHat] = 2;
                            freshCnt--;
                            pointQueue.offer(new Point(xHat, yHat));
                        }

                    }
                }
            }
            if(freshCnt <= 0) return height;
        }

        if(freshCnt > 0) return -1;

        return height;

    }




    public static void main(String[] args) {
        Prob_994 prob = new Prob_994();
//        AssertUtils.equals(4, prob.orangesRotting(new int[][] {{2,1,1}, {1,1,0}, {0,1,1}}));
        prob = new Prob_994();
        AssertUtils.equals(-1, prob.orangesRotting(new int[][] {{2,1,1}, {0,1,1}, {1,0,1}}));
        prob = new Prob_994();
        AssertUtils.equals(0, prob.orangesRotting(new int[][] {{0,2}}));
        prob = new Prob_994();
        AssertUtils.equals(0, prob.orangesRotting(new int[][] {{0,0,0}, {0,0,0}, {0,0,0}}));
        prob = new Prob_994();
        AssertUtils.equals(2, prob.orangesRotting(new int[][] {{2,1,1}, {1,2,1}, {1,1,2}}));
        prob = new Prob_994();
        AssertUtils.equals(1, prob.orangesRotting(new int[][] {{1},{2}}));
        prob = new Prob_994();
        AssertUtils.equals(-1, prob.orangesRotting(new int[][] {{1}}));
        prob = new Prob_994();
        AssertUtils.equals(0, prob.orangesRotting(new int[][] {{2}}));
        prob = new Prob_994();
        AssertUtils.equals(0, prob.orangesRotting(new int[][] {{}}));
        prob = new Prob_994();
        AssertUtils.equals(2, prob.orangesRotting(new int[][] {{2}, {1}, {1}, {1}, {2}, {1}, {1} }));

    }


}
