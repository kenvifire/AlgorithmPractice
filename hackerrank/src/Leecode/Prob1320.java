package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob1320 {
    public int deepestLeavesSum(TreeNode root) {

        return solve2(root);
    }

    private int solve2(TreeNode root) {
        int h = height(root, 0);
        return sum(root, 0, h -1 , 0);

    }

   private int sum(TreeNode root, int curr, int height, int val)  {
        if(root == null) return 0;
        if(curr == height)  return root.val + val;
        return sum(root.left, curr + 1, height, val)  + sum(root.right, curr + 1, height, val);
   }
   private int height(TreeNode root, int curr) {
        if(root == null)  return curr;
        return Math.max(height(root.left, curr + 1), height(root.right, curr + 1));
   }


    private int solve1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return sum;
    }

}
