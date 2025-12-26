package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Prob834 {
    List<Integer>[] adj;
    int[][] dist;
    boolean[] visited;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                    dist[j][i] = -1;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int x= edges[i][0];
            int y= edges[i][1];
            adj[x].add(y);
            adj[y].add(x);
        }
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < edges.length; i++) {
            visited = new boolean[n];
            sum = 0;
            for(int j = 0; j < edges[i].length; j++) {
                sum += bfs(i, i, j, 0);
            }
            res[i] = sum;
        }
        return res;

    }

    int getDist(int x, int y) {
        return dist[Math.min(x, y)][Math.max(x, y)];
    }
    void setDist(int x, int y, int d) {
        dist[Math.min(x, y)][Math.max(x, y)] = d;
    }
    int bfs(int source, int curr, int target, int d) {
        if(getDist(source, target) != -1) {
            return getDist(source, target);
        }
        visited[curr] = true;
        if(curr == target) {
            setDist(source, target, d);
            return d;
        }

        for(int next : adj[curr]) {
            if(!visited[next]) {
                if(getDist(next, target) == -1) {
                    setDist(target, source, bfs(next, source, target, d + 1));
                } else {
                    setDist(target, source, d + 1 + getDist(next, target));
                }
            }
        }
        return getDist(target, source);
    }

    public static void main(String[] args) {
        Prob834 p = new Prob834();
        System.out.println(Arrays.toString(p.sumOfDistancesInTree(3, new int[][]{{0, 1}, {0, 2} })));
        System.out.println(Arrays.toString(p.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
    }
}
