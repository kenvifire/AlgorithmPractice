package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob_671 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null || root.right == null) return -1;

        int rootValue = root.val;
        int maxValue = -1;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if(top.val > rootValue) {
                if (maxValue == -1) {
                    maxValue = top.val;
                } else if(top.val < maxValue) {
                    maxValue = top.val;
                }
            }

            if(top.left != null) queue.offer(top.left);
            if(top.right != null) queue.offer(top.right);
        }
        return maxValue;


    }
}
