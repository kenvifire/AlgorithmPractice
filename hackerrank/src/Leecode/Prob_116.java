package Leecode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob_116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            Node prev = queue.poll();
            if(prev.left != null) {
                queue.offer(prev.left);
            }
            if(prev.right != null) {
                queue.offer(prev.right);
            }
            for (int i = 1; i < n; i++) {
                Node curr = queue.poll();
                prev.next = curr;
                prev = curr;

                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }

        return root;
    }

}
