package Leecode;

public class Prob785 {
    boolean hasConflict;
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];


        hasConflict = false;
        for(int i = 0; i < graph.length; i++) {
            if(colors[i] == 0 && !hasConflict)
                dfs(graph, colors, i, 0);
        }


        return !hasConflict;



    }

    void dfs(int[][] graph, int[] colors, int current, int prev) {
        if(hasConflict) return;
        if(prev == 0) {
            colors[current] = 1;
        } else if(colors[current] == 0) {
            colors[current] = prev == 1 ? 2 : 1;
        } else {
            if(prev == colors[current]) {
                hasConflict = true;
                return;
            } else {
                return;
            }
        }


        for(int next: graph[current]) {
            dfs(graph, colors, next, colors[current]);
        }



    }
}
