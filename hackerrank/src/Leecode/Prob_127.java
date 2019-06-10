package Leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Prob_127 {
    Map<String, Integer> nodeMap;
    Map<Integer, String> idxMap;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        nodeMap = new HashMap<>();
        idxMap = new HashMap<>();

        int idx = 0;
        nodeMap.put(beginWord, idx++);
        idxMap.put(nodeMap.get(beginWord), beginWord);
        nodeMap.put(endWord, idx++);
        idxMap.put(nodeMap.get(endWord), endWord);

        for (String word: wordList) {
            if(!nodeMap.containsKey(word)) {
                nodeMap.put(word, idx);
                idxMap.put(idx, word);
                idx++;
            }
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < nodeMap.size(); i++) {
            String word = idxMap.get(i);
            List<Integer> nodeList = new ArrayList<>();

            for(String nextWord: nodeMap.keySet()) {
                if(isConnected(word, nextWord)) {
                    nodeList.add(nodeMap.get(nextWord));
                }
            }
            graph.add(nodeList);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        for (int i = 0 ; i < idxMap.size(); i++) {
            System.out.println(idxMap.get(i));
            for (Integer node : graph.get(i)) {
                System.out.print(idxMap.get(node) + ",");
            }
            System.out.println();
            System.out.println();
        }

        boolean[] visited = new boolean[graph.size()];
        int dst = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                dst++;
                Integer curr = queue.poll();
                System.out.println(idxMap.get(curr));
                if(!visited[curr]) {
                    visited[curr] = true;
                    for (Integer node : graph.get(curr)) {
                        if(!visited[node]) {
                            queue.offer(node);
                        }
                        if(node.intValue() == nodeMap.get(endWord))   {
                            return dst;
                        }
                    }
                }
            }

        }
        return 0;

    }


    boolean isConnected(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }

            if(cnt > 1) return false;
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        Prob_127 prob = new Prob_127();
        System.out.println(prob.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
