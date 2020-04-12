package Leecode;

import java.util.ArrayList;
import java.util.List;

public class Prob802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;

        List<Integer> result = new ArrayList<>();
        int[] color = new int[N];
        for(int i = 0; i < N; i++) {
            if(dfs(graph, i, color)) {
                result.add(i);
            }
        }

        return result;
    }


    private boolean dfs(int[][] graph, int current, int[] color) {
        if(color[current] > 0) {
            return color[current] == 2;
        }

        color[current] = 1;
        for(int node : graph[current]) {
            if(color[node] == 2)  continue;
            if(color[node] == 1) {
                return false;
            }
            if(!dfs(graph, node, color)) return false;
        }
        color[current] = 2;
        return true;

    }
}
