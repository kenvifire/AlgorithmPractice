package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prob1462 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Arrays.stream(prerequisites).forEach(p -> {
            int x = p[0];
            int y = p[1];
            Set<Integer> linkX = graph.getOrDefault(x, new HashSet<>());
            linkX.add(y);
            graph.put(x, linkX);
        });

        List<Boolean> result = new ArrayList<>(queries.length);
        for(int[] q : queries) {
            result.add(hasPath(graph, q[0], q[1], new boolean[n]));
        }
        return result;


    }

    private boolean hasPath(Map<Integer, Set<Integer>> graph, int curr, int target, boolean[] visited) {
        visited[curr] = true;
        if(curr == target) return true;
        for(int next : graph.getOrDefault(curr, new HashSet<>())) {
            if(!visited[next] && hasPath(graph, next, target, visited)) {
                return true;
            }
        }
        return false;
    }
}
