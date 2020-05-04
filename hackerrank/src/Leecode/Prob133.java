package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob133 {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        dfs(node, visited, nodeMap);
        return nodeMap.get(node.val);

    }

    private void dfs(Node node, Map<Integer, Boolean> visited, Map<Integer, Node> nodeMap) {
        if (visited.getOrDefault(node.val, false)) return;
        visited.put(node.val, true);
        Node clonedNode = getOrCreate(nodeMap, node.val);

        for (Node next : node.neighbors) {
            clonedNode.neighbors.add(getOrCreate(nodeMap, next.val));
            if (!visited.getOrDefault(next.val, false))
                dfs(next, visited, nodeMap);

        }

    }

    private Node getOrCreate(Map<Integer, Node> nodeMap, int val) {
        if (nodeMap.get(val) == null) {
            nodeMap.put(val, new Node(val));
        }
        return nodeMap.get(val);
    }
}
