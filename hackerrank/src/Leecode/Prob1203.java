package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prob1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        Set<Integer> groups = new HashSet<>();
        for(int i = 0; i < group.length; i++) {
            if(group[i] == -1) {
                group[i] = groupId;
                groupId++;
            }
        }
        for(int i = 0; i < groupId; i++) groups.add(i);


        List<Set<Integer>> groupSet = new ArrayList<>();
        for(int i = 0; i < groupId; i++) {
            groupSet.add(new HashSet<>());

        }

        Map<Integer, Set<Integer>> groupMap = new HashMap<>();
        List<Map<Integer, Set<Integer>>> nodeMapList = new ArrayList<>();
        for(int i = 0; i < groupId; i++) {
            nodeMapList.add(new HashMap<Integer, Set<Integer>>());
        }
        for(int i = 0; i < beforeItems.size(); i++) {
            List<Integer> items = beforeItems.get(i);
            int y = i;
            int groupY = group[y];
            groupSet.get(groupY).add(y);
            for(int x: items) {
                int groupX = group[x];
                groupSet.get(groupX).add(x);
                //node map
                Map<Integer, Set<Integer>> nodeMap = nodeMapList.get(groupX);
                Set<Integer> linkX = nodeMap.getOrDefault(x, new HashSet<>());
                if(groupX == groupY) {
                    linkX.add(y);
                }
                nodeMap.put(x, linkX);


                //group map
                Set<Integer> groupLinkX = groupMap.getOrDefault(groupX, new HashSet<>());

                if(groupX != groupY) {
                    groupLinkX.add(groupY);
                }
                groupMap.put(groupX, groupLinkX);

            }

        }

        int[] result = new int[n];


        List<Integer> groupToplogicalOrder = toplogicSort(groupMap, groups);
        if(groupToplogicalOrder == null) return new int[]{};
        int idx = 0;
        for(int j = groupToplogicalOrder.size() - 1; j >= 0; j--) {
            int g = groupToplogicalOrder.get(j);
            Map<Integer, Set<Integer>> nodeMap = nodeMapList.get(g);
            List<Integer> gList = toplogicSort(nodeMap, groupSet.get(g));
            if(gList == null) return new int[]{};
            for(int i = gList.size() - 1; i >= 0; i--) {
                result[idx++] = gList.get(i);
            }
        }
        return result;


    }

    private List<Integer> toplogicSort(Map<Integer, Set<Integer>> graph, Set<Integer> nodes) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> colors = new HashMap<>();
        for(Integer curr : nodes) {
            if(colors.getOrDefault(curr, 0) == 0) {
                boolean hasCycle = dfs(graph, curr, colors, result);
                if(hasCycle) return null;
            }
        }
        return result;

    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, int current, Map<Integer, Integer> colors, List<Integer> postOrder) {
        int currColor = colors.getOrDefault(current, 0);
        if(currColor == 1) {
            return true;
        }
        if(currColor == 2) {
            return false;
        }

        colors.put(current, 1);
        for(Integer next: graph.getOrDefault(current, new HashSet<>())) {
            int color = colors.getOrDefault(next, 0);
            if(color != 2 ) {
                boolean hasCycle = dfs(graph, next, colors, postOrder);
                if(hasCycle) return true;
            }
        }
        colors.put(current, 2);
        postOrder.add(current);
        return false;
    }
}
