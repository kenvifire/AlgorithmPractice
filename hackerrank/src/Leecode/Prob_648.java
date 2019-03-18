package Leecode;

import utils.AssertUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_648 {
    static class TrieNode  {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
        boolean isWord = false;
    }
    private TrieNode root;
    public String replaceWords(List<String> dict, String sentence) {
        initDict(dict);
        StringBuilder sb = new StringBuilder();
        Map<String, String> rootMap = new HashMap<>();
        int start, end;
        for (int i = 0; i < sentence.length(); ) {
            while (i < sentence.length() && sentence.charAt(i) == ' ') {
                i++;
                sb.append(" ");
            }
            if (i >= sentence.length()) break;
            start = i;
            while (i < sentence.length() && sentence.charAt(i) != ' ') i++;
            end = i;
            String word = sentence.substring(start, end);

            if(!rootMap.containsKey(word)) {
                String root = find(word);
                rootMap.put(word, root == null ? word : root);
            }
            sb.append(rootMap.get(word));
        }

        return sb.toString();
    }

    private void initDict(List<String> dict) {
        root = new TrieNode();
        for (String word : dict) {
            insert(word);
        }
    }

    private String find(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children.get(c);
            if(curr == null) return null;
            if(curr.isWord) return curr.word;
        }

        return curr.isWord ? curr.word : null;

    }

    private void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
        curr.word = word;
    }

    public static void main(String[] args) {
        Prob_648 prob = new Prob_648();
        AssertUtils.equals("the cat was rat by the bat", prob.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        AssertUtils.equals("a a a", prob.replaceWords(Arrays.asList("a", "aa", "ac"), "a aa aaa"));
        AssertUtils.equals("  the cat was rat by the bat  ", prob.replaceWords(Arrays.asList("cat", "bat", "rat"), "  the cattle was rattled by the battery  "));
    }

}
