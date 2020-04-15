package Leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] pre : prerequisites) {
            int x = pre[0];
            int y = pre[1];
            List<Integer> dep = graph.getOrDefault(x, new ArrayList<>());
            dep.add(y);
            graph.put(x, dep);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i] & dfs(graph, i, visited, onStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int current, boolean[] visited, boolean[] onStack) {
        if(onStack[current]) return true;
        if(visited[current]) return false;

        onStack[current] = true;
        visited[current] = true;

        for(int node : graph.getOrDefault(current, Collections.emptyList())) {
            if(dfs(graph, node, visited, onStack)) {
                return true;
            }
        }

        onStack[current] = false;
        return false;
    }
}
