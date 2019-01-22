package Leecode;

import lib.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob_598 {
    public List<Integer> preorder(Node root) {
        if(root == null) return null;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(curr.val);

            if(curr.children != null) {
                for (int i = curr.children.size() - 1; i >=0; i--) {
                    stack.add(curr.children.get(i));
                }
            }
        }

        return result;

    }
}
