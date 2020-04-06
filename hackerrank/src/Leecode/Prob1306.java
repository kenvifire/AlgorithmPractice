package Leecode;

public class Prob1306 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, visited, start);

    }

    private boolean dfs(int[] graph, boolean[] visited, int curr) {
        if(curr <0 || curr >= graph.length || visited[curr]) return false;
        visited[curr] = true;
        if(graph[curr] == 0) return true;

        int m = curr + graph[curr];
        int n = curr - graph[curr];

        return dfs(graph, visited, m) || dfs(graph, visited, n);
    }
}
