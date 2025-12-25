package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob212 {
    boolean[][] visited;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    List<String> result;

    public List<String> findWords(char[][] board, String[] words) {

        result = new ArrayList<>();
        Trie root = new Trie();
        for (String word :words) {
            root.insert(word);
        }

        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(root.root.children.containsKey(board[i][j])) {
                    bfs(board, i, j, result, root.root);
                }
            }
        }
        return result;
    }

    public void bfs(char[][] board, int x, int y, List<String> result, TireNode node) {

        TireNode currNode = node.get(board[x][y]);
        visited[x][y] = true;

        if(currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        for(int[] direct :directions) {
            int x_h = x + direct[0];
            int y_h = y + direct[1];
            if(x_h >= 0 && x_h < board.length && y_h >= 0 && y_h < board[0].length &&
                    !visited[x_h][y_h] &&
                    currNode.children.containsKey(board[x_h][y_h])) {
                bfs(board, x_h, y_h, result, currNode);
            }
        }
        visited[x][y]=false;
        if(currNode.children.isEmpty()) {
            node.children.remove(board[x][y]);
        }

    }

    class TireNode {
        Map<Character, TireNode> children;
        String word = null;
        private boolean isEnd;

        public TireNode() {
            children = new HashMap<>();
            isEnd = false;
        }

        public void put(char ch, TireNode trieNode) {
            children.put(ch, trieNode);
        }

        public TireNode get(char ch) {
            return children.get(ch);
        }


    }

    class Trie {
        private TireNode root;

        public Trie() {
            root = new TireNode();
        }
        public void insert(String word) {
            TireNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if(node.get(curr) == null) {
                    node.put(curr, new TireNode());
                }
                node = node.get(curr);
            }
            node.isEnd = true;
            node.word = word;
        }

    }
}
