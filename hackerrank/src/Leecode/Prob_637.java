package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Prob_637 {
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();

        List<Double> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            double sum = 0.0;

            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(sum / n);
        }


        return result;
    }
}
