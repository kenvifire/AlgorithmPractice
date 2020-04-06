package Leecode;

import java.util.List;

public class Prob841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);

        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) return false;
        }
        return true;

    }
    void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        if(visited[node]) return;
        visited[node] = true;

        for(int room : graph.get(node)) {
            if(!visited[room]) {
                dfs(graph, visited, room);
            }
        }

    }
    
}
