package Leecode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Prob_720 {

    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>(Comparator.reverseOrder());
        boolean isWorld = false;
        String actualWorld;

    }
    static class TrieTree {
        private TrieNode root;

        public TrieTree() {
            root = new TrieNode();
            root.isWorld = true;
        }

        public void add(String str) {
            TrieNode current = root;

            for (int i = 0; i < str.length(); i++) {
                current = current.children.computeIfAbsent(str.charAt(i), c -> new TrieNode());
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
                    if(entry.getValue().isWorld) {
                        queue.offer(entry.getValue());
                    }
                }

            }
            return current;
        }

        public String getLongest() {
            return findLongest().actualWorld;
        }
    }

    public String longestWord(String[] words) {
        TrieTree trieTree = new TrieTree();
        for (String word : words) {
            trieTree.add(word);
        }
        return trieTree.getLongest();
    }

    public static void main(String[] args) {
        String[] words = new String[] {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
        Prob_720 prob= new Prob_720();

        System.out.println(prob.longestWord(words));


        words = new String[] {"a"};
        System.out.println(prob.longestWord(words));

        words = new String[] {"a", "b", "cd", "bb"};
        System.out.println(prob.longestWord(words));
    }
}
