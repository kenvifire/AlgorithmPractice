package Leecode;

import lib.Node;
import utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Prob_429 {

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return Collections.emptyList();
        Queue<Node> queue = new ArrayDeque<>();

        Node last = root;
        Node lastChildNotNull = root;
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node front = queue.poll();

            current.add(front.val);
            if(front == last) {
                result.add(current);
                current = new ArrayList<>();
                last = getLast(lastChildNotNull);
                lastChildNotNull = getLastChildNodeNull(lastChildNotNull);
            }

            if(front.children != null) {
                queue.addAll(front.children);
            }

        }

        if(current.size() > 0) {
            result.add(current);
        }

        return result;
    }

    private Node getLast(Node node) {
        if(node.children != null && node.children.size() != 0) {
            return node.children.get(node.children.size() - 1);
        }
        return null;
    }

    private Node getLastChildNodeNull(Node node) {
        if(node == null || node.children == null || node.children.size() == 0) return null;
        for (int i = node.children.size() - 1; i>=0; i -- ) {
            if(node != null) return node;
        }
        return null;
    }

    public static void main(String[] args) {
        //Node root = new Node(1, Arrays.asList(new Node(2, Arrays.asList(new Node(3, Collections.emptyList()))))) ;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node2 = new Node(2);

        Node node3 = new Node(3, node4, node5, node6, node7);

        Node node1 = new Node(1, node2, node3);

        new Prob_429().levelOrder(node1).stream().forEach(e -> PrintUtils.printIntList(e));
    }
}
