package Leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/
 */
public class Prob1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] colors = new int[N];
        for(int i = 0; i < N; i++) colors[i] = -1;

        for(int[] path: paths) {
            int x = path[0];
            int y = path[1];

            List<Integer> linkX = graph.getOrDefault(x, new ArrayList<Integer>());
            linkX.add(y);
            graph.put(x, linkX);

            List<Integer> linkY = graph.getOrDefault(y, new ArrayList<Integer>());
            linkY.add(x);
            graph.put(y, linkY);

        }

        for(int i = 0; i < N; i++) dfs(graph, colors, i );

        return colors;
    }

    void dfs(Map<Integer, List<Integer>> graph, int[] colors, int curr) {
        Set<Integer> colorSet = new HashSet<Integer>();
        colorSet.add(1);
        colorSet.add(2);
        colorSet.add(3);
        colorSet.add(4);

        for(int p : graph.getOrDefault(curr + 1, Collections.emptyList())) {
            if(colors[p - 1] > 0) {
                colorSet.remove(colors[p - 1]);
            }
        }
        Iterator<Integer> it = colorSet.iterator();
        colors[curr] = it.next();

        for(int p : graph.getOrDefault(curr + 1, Collections.emptyList())) {
            if(colors[p - 1] < 0) {
                dfs(graph, colors, p - 1);
            }
        }
    }
}
