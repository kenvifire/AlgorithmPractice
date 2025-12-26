package Leecode;

import java.util.*;

public class Prob1368 {

    static class Point {
        int x, y, dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int hashCode() {
            return this.x * 31 + this.y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }
    }
    Set<Point> visited = new HashSet<>();

    int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] costs ;
    int m, n;

    public int minCost(int[][] grid) {
        costs = new int[grid.length][grid[0].length];
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }

        costs[0][0] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(p -> p.dist));
        pq.add(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if(visited.contains(p)) continue;
            visited.add(p);

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dirs[i][0];
                int newY = p.y + dirs[i][1];
                if(newX >= 0 && newX < m && newY >= 0 && newY < n && !visited.contains(new Point(newX, newY, 0))) {
                    int c = ((i-1) == grid[newX][newY]) ? 0 : 1;

                    if(costs[newX][newY] > costs[p.x][p.y] + c) {
                        costs[newX][newY] = c + costs[p.x][p.y];
                        pq.add(new Point(newX, newY, costs[newX][newY]));
                    }
                }
            }

        }

        return costs[m - 1][n - 1];

    }

    public static void main(String[] args) {
        Prob1368 p = new Prob1368();
        System.out.println(p.minCost(new int[][]{{1,2}, {4,3}}));
    }

}
