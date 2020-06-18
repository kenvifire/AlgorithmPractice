package Leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Prob310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Arrays.stream(edges).forEach(edge -> {
            int x = edge[0];
            int y = edge[1];
            Set<Integer> linkX = graph.getOrDefault(x, new HashSet<>());
            linkX.add(y);
            graph.put(x, linkX);

            Set<Integer> linkY = graph.getOrDefault(y, new HashSet<>());
            linkY.add(x);
            graph.put(y, linkY);
        });

        Queue<Integer> queue = new ArrayDeque<>();
        graph.forEach((k,v) -> {
            if(v.size() == 1) queue.add(k);
        });

        while(!queue.isEmpty()) {
            if(graph.keySet().size() < 3) return new ArrayList<>(graph.keySet());

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Integer x = queue.poll();

                for(int next: graph.get(x)) {
                    graph.get(next).remove(x);
                    if(graph.get(next).size() == 1) {
                        queue.add(next);
                    }
                }
                graph.remove(x);
            }
        }
        return null;

    }
}
