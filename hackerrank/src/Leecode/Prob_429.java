package Leecode;

import com.google.gson.Gson;
import lib.Node;
import utils.JGraphXAdapterDemo;
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

        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                current.add(node.val);

                if(node.children != null) {
                    queue.addAll(node.children);
                }
            }
            result.add(current);

        }


        return result;
    }




    public static void main(String[] args) {
        Node node10 = new Node(10);
        Node node11 = new Node(11);

        Node node8 = new Node(8, node10, node11);
        Node node9 = new Node(9);
        Node node5 = new Node(5, node8, node9);

        Node node4 = new Node(4);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node2 = new Node(2, node4, node5);

        Node node3 = new Node(3, node6, node7);

        Node node1 = new Node(1, node2, node3);



        //Node root = new Node(1, Arrays.asList(new Node(2, Arrays.asList(new Node(3, Collections.emptyList()))))) ;
//        Node root = new Gson().fromJson(json, Node.class);

//        JGraphXAdapterDemo demo = new JGraphXAdapterDemo(node1);

//        demo.showGraph();


        new Prob_429().levelOrder(node1).stream().forEach(e -> PrintUtils.printIntList(e));
    }
}
