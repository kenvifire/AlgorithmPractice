package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/redundant-connection/
 */
public class Prob684 {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            boolean[] visited = new boolean[edges.length + 1];
            if(graph.containsKey(x) && hasPath(graph, visited, x, y)) {
                return edge;
            }

            List<Integer> linkX = graph.getOrDefault(x, new ArrayList<Integer>());
            linkX.add(y);
            graph.put(x, linkX);
            List<Integer> linkY = graph.getOrDefault(y, new ArrayList<Integer>());
            linkY.add(x);
            graph.put(y, linkY);

        }
        return edges[0];

    }

    boolean hasPath(Map<Integer, List<Integer>> graph, boolean[] visited, int current, int target) {
        if(current == target) return true;

        visited[current] = true;

        for(int node : graph.get(current)) {
            if(!visited[node] && hasPath(graph, visited, node, target))  {
                return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection_UF(int[][] edges) {
        int[] uf = new int[edges.length + 1];
        for(int i = 1; i < edges.length; i++) uf[i] = i;
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            if(isConnected(uf, x, y)) return edge;
            connect(uf, x, y);
        }

        return edges[0];

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

    private boolean isConnected(int[] uf, int p, int q) {
        return find(uf, p) == find(uf, q);
    }
}
