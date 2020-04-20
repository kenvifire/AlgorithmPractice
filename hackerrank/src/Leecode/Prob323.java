package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob323 {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            List<Integer> linkX = graph.getOrDefault(x, new ArrayList<Integer>());
            linkX.add(y);
            graph.put(x, linkX);

            List<Integer> linkY = graph.getOrDefault(y, new ArrayList<Integer>());
            linkY.add(x);
            graph.put(y, linkY);
        }

        int size = 0;

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                size++;
                dfs(graph, i, visited);
            }
        }

        return size;


    }
    private void dfs(Map<Integer, List<Integer>> graph, int curr, boolean[] visited) {
        visited[curr] = true;

        for(int node: graph.getOrDefault(curr, new ArrayList<Integer>())) {
            if(!visited[node]) {
                dfs(graph, node, visited);
            }
        }
    }

    public int countComponents_uf(int n, int[][] edges) {
        int[] uf = new int[n];

        for(int i = 0; i < n; i++) uf[i] = i;

        for(int[] edge : edges) {
            connect(uf, edge[0], edge[1]);
        }

        int size = 0;
        for(int i = 0; i < n; i++) {
            if(uf[i] == i) size++;
        }

        return size;
    }

    private int find(int[] uf, int p) {
        while(p != uf[p]) p = uf[p];
        return p;
    }

    private void connect(int[] uf, int p, int q) {
        int rootP = find(uf, p);
        int rootQ = find(uf, q);

        uf[rootP] = rootQ;
    }
}
