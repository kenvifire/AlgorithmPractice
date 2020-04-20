package Leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Prob1136 {
    boolean hasCycle = false;
    int maxLength = -1;
    public int minimumSemesters(int N, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        Map<Integer, Integer> depMap = new HashMap<>();
        for(int i = 0; i < N; i++) depMap.put(i, 0);

        for(int i = 0; i < relations.length; i ++) {
            int x = relations[i][0] - 1;
            int y = relations[i][1] - 1;
            int cnt = depMap.getOrDefault(y, 0);
            depMap.put(y, cnt++);

            graph.get(x).add(y);
        }

        Set<Integer> zeroDep = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : depMap.entrySet()) {
            if(entry.getValue() == 0) zeroDep.add(entry.getKey());
        }

        if(zeroDep.isEmpty()) {
            return -1;
        }
        int max = -1;
        int[] depth = new int[N];
        for(int node : zeroDep) {
            boolean[] onStack = new boolean[N];
            int curr = dfs(graph, depth, onStack, node);
            if(hasCycle) {
                return -1;
            }
            if(curr > max) max = curr;
        }
        return maxLength ;

    }

    private int dfs(List<List<Integer>> graph, int[] depth,  boolean[] onStack, int node) {
        if(onStack[node]) {
            hasCycle = true;
        }
        if(depth[node] > 0 || hasCycle) return depth[node];

        onStack[node] = true;

        int max = 0;
        for(int next : graph.get(node)) {
            int currHeight = dfs(graph, depth, onStack, next );
            if(currHeight > max) {
                max = currHeight;
            }
        }
        onStack[node] = false;
        depth[node] = max + 1;
        if(depth[node]> maxLength) maxLength = depth[node];
        return depth[node];
    }


    public int minimumSemesters_toplogicSort(int N, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        Map<Integer, Integer> depMap = new HashMap<>();
        for(int i = 0; i < N; i++) depMap.put(i, 0);

        for(int i = 0; i < relations.length; i ++) {
            int x = relations[i][0] - 1;
            int y = relations[i][1] - 1;
            int cnt = depMap.getOrDefault(y, 0) + 1;
            depMap.put(y, cnt);

            graph.get(x).add(y);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(Map.Entry<Integer, Integer> entry: depMap.entrySet()) {
            if(entry.getValue() == 0) queue.add(entry.getKey());
        }

        int level = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();

            for(int i = 0; i < n; i++ ) {
                int curr = queue.poll();
                for(int next : graph.get(curr)) {
                    int val = depMap.get(next) - 1;
                    depMap.put(next, val);
                    if(val == 0) {
                        queue.add(next);
                    }
                }
            }
            level++;
        }
        for(Map.Entry<Integer, Integer> entry: depMap.entrySet()) {
            if(entry.getValue() > 0)  return -1;
        }

        return level;

    }
}
