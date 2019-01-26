package Leecode;

import lib.Node;
import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Prob_590 {
    public List<Integer> postorder(Node root) {
        if(root == null) return Collections.emptyList();

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        List<Integer> result = new ArrayList<>();
        Node prev = null;

        while (!stack.isEmpty()) {
            Node curr = stack.peek();

            if((curr.children == null || curr.children.size() == 0) ||
                    (prev != null && prev == findLastNonNull(curr.children))) {
                stack.pop();
                result.add(curr.val);
                prev = curr;
            }else {
                for (int i = curr.children.size() -1 ; i >= 0; i--) {
                    stack.add(curr.children.get(i));
                }
            }
        }

        return result;

    }

    private Node findLastNonNull(List<Node> children) {
        for (int i = children.size() - 1; i >= 0; i--) {
            if(children.get(i) != null) return children.get(i);
        }
        return null;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node node3 = new Node(3, Arrays.asList(node5, node6));

        Node node2 = new Node(2);
        Node node4 = new Node(4);

        Node node1 = new Node(1, Arrays.asList(node3, node2, node4));


        PrintUtils.printIntList(new Prob_590().postorder(node1));


    }

}
