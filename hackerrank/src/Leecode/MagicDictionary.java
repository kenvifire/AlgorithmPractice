package Leecode;

import java.util.HashMap;
import java.util.Map;

class MagicDictionary {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        char ch;
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word : dict) {
            insert(word);
        }

    }

    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.ch = c;
        }

        curr.isWord = true;

    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return search(1, root, word);
    }

    private boolean search(int remain, TrieNode node, String word) {
        if(word.length() == 0) {
            return remain == 0 && node.isWord;
        }
        for (char key : node.children.keySet()) {
            if(key == word.charAt(0)) {
                if(search(remain, node.children.get(key), word.substring(1))) {
                    return true;
                }

            } else {
                if(remain == 1) {
                    if(search(0, node.children.get(key),word.substring(1))) {
                        return true;
                    }
                }
            }

        }

        return false;

    }
}
