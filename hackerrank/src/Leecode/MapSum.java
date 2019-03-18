package Leecode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    private TrieNode root;
    Map<String, Integer> valMap;
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int score;
    }

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
        valMap = new HashMap<>();

    }

    public void insert(String key, int val) {
        TrieNode p = root;
        int delta = val - valMap.getOrDefault(key, 0);
        valMap.put(key, val);


        for (char c : key.toCharArray()) {
            p.children.putIfAbsent(c, new TrieNode());
            p = p.children.get(c);
            p.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            p = p.children.get(c);
            if(p == null) return 0;
        }
        return p.score;

    }
}
