package Leecode.contest198;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob5465 {
    Map<Integer, Map<Character, Integer>> globalMap = new HashMap<>();

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
                List<Integer> linkX = graph.getOrDefault(x, new ArrayList<>());
                linkX.add(y);
                graph.put(x, linkX);

                List<Integer> linkY = graph.getOrDefault(y, new ArrayList<>());
                linkY.add(x);
                graph.put(y, linkY);
        }
        boolean[] visited = new boolean[n];

        dfs(graph, 0, labels, visited );

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = globalMap.get(i).getOrDefault(labels.charAt(i), 0);
        }
        return result;

    }


    Map<Character, Integer> dfs(Map<Integer, List<Integer>> graph, int curr, String labels, boolean[] visited) {
        visited[curr] = true;
        if (globalMap.containsKey(curr)) return globalMap.get(curr);
        Map<Character, Integer> currMap = new HashMap<>();
        for (int next : graph.getOrDefault(curr, Collections.emptyList())) {
            if(visited[next]) continue;
            Map<Character, Integer> nextMap = dfs(graph, next, labels, visited);


            for (Map.Entry<Character, Integer> entry : nextMap.entrySet()) {
                Character key = entry.getKey();
                int value = entry.getValue();
                currMap.put(key, currMap.getOrDefault(key, 0) + value);
            }
        }
        char ch = labels.charAt(curr);
        currMap.put(ch, currMap.getOrDefault(ch, 0) + 1);

        globalMap.put(curr, currMap);
        return currMap;
    }

    public static void main(String[] args) {
        Prob5465 prob5465 = new Prob5465();
        prob5465.countSubTrees(4, new int[][] {
                {0,2},{0,3},{1,2}
        }, "aeed");
    }

}
