package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob_437 {
    private int total = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                dfs(current, sum);

                if(current.left != null) queue.offer(current.left);

                if(current.right != null) queue.offer(current.right);

            }
        }
        return total;

    }

    private void dfs(TreeNode root, int left) {
        if(root == null) return;
        if(root.val == left) {
            total++;
        }

        if(root.left != null) dfs(root.left, left - root.val);
        if(root.right != null) dfs(root.right, left - root.val);
    }
}
