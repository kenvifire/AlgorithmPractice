package Leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob210 {
    boolean hasCycle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        hasCycle = false;
        for(int[] pre : prerequisites) {
            int x = pre[0];
            int y = pre[1];
            List<Integer> linkX = graph.getOrDefault(x, new ArrayList<Integer>());
            linkX.add(y);
            graph.put(x, linkX);
        }

        int[] colors = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(colors[i] == 0 && !hasCycle)
                dfs(graph, i, colors, result);
        }
        int[] r = new int[numCourses];
        for(int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return hasCycle? new int[0] : r;

    }

    void dfs(Map<Integer, List<Integer>> graph, int curr, int[] colors, List<Integer> result) {
        if(colors[curr] == 1) {
            hasCycle = true;
        }

        if(hasCycle || colors[curr] == 2) {
            return;
        }

        colors[curr] = 1;
        for(int node : graph.getOrDefault(curr, Collections.emptyList())) {
            if(colors[node] != 2) {
                dfs(graph, node, colors, result);
            }
        }
        colors[curr] = 2;
        result.add(curr);
    }
}
