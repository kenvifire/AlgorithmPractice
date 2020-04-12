package Leecode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 */
public class Prob1162 {
    int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        int max = -1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        if(queue.size() == 0 || queue.size() == m*n) return -1;

        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                max = Math.max(max, grid[x][y]);
                int dist = grid[x][y] + 1;

                for(int[] direct : directions) {
                    int nextX = x + direct[0];
                    int nextY = y + direct[1];

                    if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0) {
                        grid[nextX][nextY] = dist;
                        queue.add(new int[] {nextX, nextY});
                    }


                }
            }


        }

        return max - 1;
    }
}
