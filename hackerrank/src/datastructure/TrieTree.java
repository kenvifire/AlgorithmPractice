package datastructure;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TrieTree {

    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>(Comparator.reverseOrder());
        boolean isWorld = false;
        String actualWorld;

    }
    private TrieNode root;

    public TrieTree() {
       root = new TrieNode();
    }

    public void add(String str) {
        TrieNode current = root;

        for (int i = 0; i < str.length(); i++) {
            current = current.children.computeIfAbsent(str.charAt(i),  c -> new TrieNode());
        }

        current.isWorld = true;
        current.actualWorld = str;
    }

    public TrieNode findLongest() {
        Queue<TrieNode> queue = new ArrayDeque<>();
        queue.offer(root);

        TrieNode current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
                queue.offer(entry.getValue());
            }

        }
        return current;
    }

    public String getLongest() {
        return findLongest().actualWorld;
    }





}
