package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Prob_515 {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode>  queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode top = queue.poll();
                if(top.val > max) {
                    max = top.val;
                }

                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
            result.add(max);
        }

        return result;

    }
}
