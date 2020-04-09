package Leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 */
public class Prob1267 {
    public int countServers(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] visited = new boolean[M][N];

        int[][] size = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                size[i][j] = -1;
            }
        }

        int total = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int s = dfs(grid, visited, size, i, j);
                    if (s > 1) total += s;
                }
            }
        }
        return total;


    }

    private int dfs(int[][] graph, boolean[][] visited, int[][] size, int x, int y) {
        if (visited[x][y]) return 0;
        if (size[x][y] > -1) return size[x][y];
        visited[x][y] = true;
        int temp = 1;
        int M = graph.length;
        int N = graph[0].length;


        int xNext = 0;
        int yNext = y;
        for (int i = 0; i < M; i++) {
            xNext = i;
            if (xNext >= 0 && xNext < graph.length && yNext >= 0 && yNext < graph[0].length && !visited[xNext][yNext] && graph[xNext][yNext] == 1) {
                temp += dfs(graph, visited, size, xNext, yNext);
            }

        }
        xNext = x;
        for (int i = 0; i < N; i++) {
            yNext = i;
            if (xNext >= 0 && xNext < graph.length && yNext >= 0 && yNext < graph[0].length && !visited[xNext][yNext] && graph[xNext][yNext] == 1) {
                temp += dfs(graph, visited, size, xNext, yNext);
            }
        }


        size[x][y] = temp;
        return temp;
    }

    public int countServers_uf(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] uf = new int[M*N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                uf[i * N + j] = i * N + j;
            }
        }

        for(int i = 0; i < M; i++) {
            int prev = -1;
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1) {
                    if(prev == -1) {
                        prev = i * N + j;
                    } else {
                        int curr = i * N + j;
                        connect(uf, prev, curr);
                    }
                }
            }
        }
        for(int i = 0; i < N; i++) {
            int prev = -1;
            for(int j = 0; j < M; j++) {
                if(grid[j][i] == 1) {
                    if(prev == -1) {
                        prev = j * N + i;
                    } else {
                        int curr = j * N + i;
                        connect(uf, prev, curr);
                    }
                }
            }
        }

        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int root = find(uf, i * N + j);
                int val = cntMap.getOrDefault(root, 0);
                cntMap.put(root, val+1);
            }
        }

        int total = 0;
        for(Map.Entry<Integer, Integer> entry: cntMap.entrySet()) {
            if(entry.getValue() > 1)  total += entry.getValue();
        }
        return total;



    }

    private void connect(int[] uf, int p, int q) {
        int rootP = find(uf, p);
        int rootQ = find(uf, q);
        uf[rootP] = rootQ;
    }

    private int find(int[] uf, int p) {
        while(p != uf[p]) p = uf[p];
        return p;
    }
}
