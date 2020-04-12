package Leecode;

import java.util.ArrayList;
import java.util.List;

public class Prob1059 {
    boolean reached = false;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        int[] color = new int[n];
        return dfs(graph, color, source, destination) && reached;

    }


    boolean dfs(List<List<Integer>> graph,int[] color, int curr, int dest) {
        if(curr == dest && graph.get(dest).isEmpty()) {
            reached = true;
            return true;
        }
        if(graph.get(curr).isEmpty() && curr != dest) {
            return false;
        }

        if(color[curr] == 1) return false;

        if(color[curr] > 0) {
            return color[curr] == 2;
        }
        color[curr] = 2;
        color[curr] = 1;

        for(int node : graph.get(curr)) {
            if(color[node] == 2) continue;
            else if(color[node] == 1) return false;
            else if(!dfs(graph, color, node, dest)) {
                return false;
            }

        }

        color[curr] = 2;
        return true;
    }
}
